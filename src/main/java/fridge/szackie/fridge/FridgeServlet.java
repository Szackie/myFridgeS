package fridge.szackie.fridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fridge")
public class FridgeServlet {

    private FridgeRepository fridgeRepository;

    private final Logger logger = LoggerFactory.getLogger(FridgeServlet.class);

    public FridgeServlet(FridgeRepository repository) {
        this.fridgeRepository = repository;
    }


    @PostMapping
    ResponseEntity<Fridge> saveFridge(@RequestBody Fridge fridge){
        for(Fridge fridgeFromDB: fridgeRepository.findAll()) {
            if (fridge.getName().equals(fridgeFromDB.getName()))
                return ResponseEntity.ok(fridgeFromDB);
        }
        return ResponseEntity.ok(fridgeRepository.save(fridge));
    }

    @GetMapping
    ResponseEntity<List<Fridge>> findAllFridges() {
        logger.info("Request sended");
        return ResponseEntity.ok(fridgeRepository.findAll());
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Optional<Fridge>> deleteFridge(@PathVariable Integer id) {
        var fridge = fridgeRepository.findById(id);
        fridge.ifPresent(f -> {
            fridgeRepository.delete(f);
        });
        return Optional.ofNullable(ResponseEntity.ok(fridge)).orElse(ResponseEntity.notFound().build());
    }
}

