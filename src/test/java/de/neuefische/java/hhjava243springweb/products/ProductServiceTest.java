package de.neuefische.java.hhjava243springweb.products;

import de.neuefische.java.hhjava243springweb.utils.IdService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    ProductRepo productRepo = mock(ProductRepo.class);
    IdService idService = mock(IdService.class);
    ProductService productService = new ProductService(productRepo, idService);

    @Test
    void findAllProductsTest_EmptyList() {
        //GIVEN

        //WHEN
        List<Product> actual = productService.findAllProducts();

        //THEN
        List<Product> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    void findAllProductsTest() {
        //GIVEN
        Product p1 = new Product("1", "Apfel", "Lecker", 3);
        List<Product> products = List.of(p1);

        when(productRepo.findAll()).thenReturn(products);

        //WHEN
        List<Product> actual = productService.findAllProducts();

        //THEN
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("1", "Apfel", "Lecker", 3));

        verify(productRepo).findAll();
        assertEquals(expected, actual);
    }


    @Test
    void saveProduct() {
        //GIVEN
        NewProductDto productDto = new NewProductDto("Apfel", "Lecker");
        Product product = new Product("1", "Apfel", "Lecker", 5);

        when(productRepo.save(product)).thenReturn(product);
        when(idService.randomId()).thenReturn("1");

        //WHEN
        Product actual = productService.saveProduct(productDto);

        //THEN
        Product expected = new Product("1", "Apfel", "Lecker", 5);
        verify(idService).randomId();
        verify(productRepo).save(product);
        assertEquals(expected, actual);
    }
}
