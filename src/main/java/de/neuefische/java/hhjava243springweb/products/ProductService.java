package de.neuefische.java.hhjava243springweb.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Product saveProduct(Product product) {
        Product productToSave = product
                .withId(UUID.randomUUID().toString())
                .withPrice(5);

        return productRepo.save(productToSave);
    }
}

