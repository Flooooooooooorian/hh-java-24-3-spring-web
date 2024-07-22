package de.neuefische.java.hhjava243springweb.products;

import de.neuefische.java.hhjava243springweb.utils.IdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final IdService idService;

    public List<Product> findAllProducts() {
        //Mehr Logik
        return productRepo.findAll();
    }

    public Product saveProduct(NewProductDto product) {
        System.out.println("SAVE");
        Product productToSave = new Product(
                idService.randomId(),
                product.title(),
                product.description(),
                5);
        System.out.println("SAVE");

        return productRepo.save(productToSave);
    }
}

