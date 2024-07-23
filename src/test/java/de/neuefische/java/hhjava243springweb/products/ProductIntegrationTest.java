package de.neuefische.java.hhjava243springweb.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepo productRepo;

    @Test
    @DirtiesContext
    void getAllProducts() throws Exception {
        //GIVEN
        productRepo.save(new Product("1", "Apfel", "Lecker", 7));

        //WHEN
        mockMvc.perform(get("/api/products"))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                             {
                             "id": "1",
                             "title": "Apfel",
                             "description": "Lecker",
                             "price": 7
                             }
                         ]
                        """));

    }

    @Test
    @DirtiesContext
    void postProduct() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "title": "Banana",
                          "description": "Auch lecker"
                        }
                        """))
                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "title": "Banana",
                            "description": "Auch lecker",
                            "price": 5
                        }
                        """))
                .andExpect(jsonPath("$.id").exists());

    }
}
