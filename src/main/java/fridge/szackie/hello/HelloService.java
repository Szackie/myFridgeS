package fridge.szackie.hello;

import fridge.szackie.lang.Lang;
import fridge.szackie.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
class HelloService {
    final static String FALLBACK_NAME = "";
    final static Lang FALLBACK_LANG = new Lang(1, "Products from fridge: ","en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);
    private LangRepository repository;


        HelloService(LangRepository repository){
            this.repository=repository;
        }

    String prepareGreeting(String name, Integer langId) {
        langId=Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());

        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg+ " "+nameToWelcome+"!";
    }
}
