package fridge.szackie.hello;

import fridge.szackie.config.JwtUtils;
import fridge.szackie.dao.User;
import fridge.szackie.dao.UserDao;
import fridge.szackie.hello.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response) {

//        fixme poniższa metoda działa tylko z zahardkodowaną listą userów (coś z UserDetails musi być nie tak)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );

        final User user= userDao.findByEmail(request.getEmail());
        if(user!=null){
            var token=jwtUtils.generateToken(user);
            Cookie cookie=new Cookie("token",token);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setPath("/");
            System.out.println("NAZWA COOKIE"+ cookie.getName()+"TOKEN W COOKIE: "+cookie.getValue());
            response.addCookie(cookie);

            return ResponseEntity.ok(token);
        }else {
            // TODO utwórz usera
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
           // user.setAuthorities(authorities);
        }
        return  ResponseEntity.status(400).body("Some error has Occured");

    }
}
