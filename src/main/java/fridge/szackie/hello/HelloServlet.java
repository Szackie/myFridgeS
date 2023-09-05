package fridge.szackie.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
class HelloServlet {
    private HelloService service;
    private static final String LANG_PARAM="lang";
    private static final String NAME_PARAM="name";
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);


    public HelloServlet(HelloService service)
    {
        this.service = service;
    }

    @GetMapping("/api")
    String welcome() {
        return welcome(null,null);
    }

    @GetMapping(value="/api", params = {"lang","name"})
     String welcome(@RequestParam("lang") Integer langId, @RequestParam String name) {

        return service.prepareGreeting(name,langId);
    }
}
