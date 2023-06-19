package fridge.szackie.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductServlet {

    private ProductRepository productRepository;
    private final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    public ProductServlet(ProductRepository repository) {
        this.productRepository = repository;
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> toggleProduct(@PathVariable Integer id) {
        var product = productRepository.findById(id);
        product.ifPresent(p -> {
            p.setDone(!p.isDone());
            productRepository.save(p);
        });
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping
    ResponseEntity<List<Product>> findAllProducts() {
        logger.info("Request sended");
        return ResponseEntity.ok(productRepository.findAll());
    }

    //FIXME

    @DeleteMapping
    ResponseEntity<List<Product>> deleteProducts(@RequestBody Map<String,Object> req) {
        List<Product> productList=new ArrayList<>();
        Integer fridgeId=(Integer) req.get("fridge_id");
        for (Product product : productRepository.findAll())
            //FIXME
            if (product.isDone()&&product.getFridge_id().equals(fridgeId)) {
                productList.add(product);
                productRepository.deleteById(product.getId());

            }

        return ResponseEntity.ok(productList);
    }
}