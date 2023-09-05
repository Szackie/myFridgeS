package fridge.szackie.hello;

import fridge.szackie.config.JwtUtils;
import fridge.szackie.dao.UserDao;
import fridge.szackie.hello.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );

        final UserDetails user= userDao.findUserByEmail(request.getEmail());
        if(user!=null){

            var token=jwtUtils.generateToken(user);
            Cookie cookie=new Cookie("token",token);
            cookie.setPath("/");
            System.out.println("NAZWA COOKIE"+ cookie.getName()+"TOKEN W COOKIE: "+cookie.getValue());
            response.addCookie(cookie);

            return ResponseEntity.ok(token);
        }
        return  ResponseEntity.status(400).body("Some error has Occured");

    }
}
