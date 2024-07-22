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

    public Product saveProduct(NewProductDto product) {
        Product productToSave = new Product(
                UUID.randomUUID().toString(),
                product.title(),
                product.description(),
                5);

        return productRepo.save(productToSave);
    }
}

