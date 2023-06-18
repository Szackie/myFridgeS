package fridge.szackie.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import java.util.List;


@RestController
@RequestMapping("/api")
class LangServlet {

    private LangService service;

    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    public LangServlet(LangService langService) {
        this.service = langService;
    }

@GetMapping("/langs")
ResponseEntity<List<LangDTO>> findAllLangs(){
        logger.info("Request goes");
return ResponseEntity.ok(service.findAll());
    }
}
