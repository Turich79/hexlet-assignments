package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "")
    public List<Product> index() {
        return productRepository.findAll();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // BEGIN
    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {
        var product =  productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }

    @PutMapping(path = "/{id}")
    public Product update(@PathVariable long id, @RequestBody Product productData) {
        var product =  productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        product.setTitle(productData.getTitle());
        product.setPrice(productData.getPrice());

        productRepository.save(product);

        return product;
    }
//    @GetMapping("/products/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<Product> show(@PathVariable Long id) {
//        var product = productRepository.findById(id);
//        return ResponseEntity.of(product);
//    }
//    @ResponseStatus(HttpStatus.OK)
//    public Product show(@PathVariable Long id) {
//        var product = productRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(id + " Not Found"));
//        return product;
//    }
//
//    @PutMapping("/products/{id}")
//    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
//        var maybeProduct = productRepository.findById(id);
//        var status = HttpStatus.NO_CONTENT;
//        if (maybeProduct.isPresent()) {
//            var data = maybeProduct.get();
//            product.setId(data.getId());
//            product.setTitle(data.getTitle());
//            product.setPrice(data.getPrice());
//            status = HttpStatus.OK;
//        }
//        return ResponseEntity.status(status).body(product);
//    }
    // END

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}