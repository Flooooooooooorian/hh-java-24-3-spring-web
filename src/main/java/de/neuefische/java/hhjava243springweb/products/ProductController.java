package de.neuefische.java.hhjava243springweb.products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    //Dependency Injection
    private final ProductRepo productRepo;

//    public ProductController(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        return allProducts;
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product) {
        Product productToSave = product.withPrice(5);

        return productRepo.save(productToSave);
    }
}
