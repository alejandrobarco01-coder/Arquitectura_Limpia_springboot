package co.edu.taller6.cleanarchitecture.infrastructure.web;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import co.edu.taller6.cleanarchitecture.CleanArchitectureApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = CleanArchitectureApplication.class)
@AutoConfigureMockMvc
class ApiContractTest {
    @Autowired private MockMvc mockMvc;

    @Test void categoriesReturnsTheSharedCatalogContract() throws Exception {
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Carnes"))
                .andExpect(jsonPath("$[0].description").value("Carnes y proteínas"));
    }

    @Test void apiRootIsDiscoverable() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Clean Architecture Spring Boot API"))
                .andExpect(jsonPath("$.endpoints.categories").value("/api/categories"))
                .andExpect(jsonPath("$.swaggerUi").value("/api/swagger-ui.html"));
    }

    @Test void usersAndProductsKeepAngularProperties() throws Exception {
        mockMvc.perform(get("/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].lastName").exists())
                .andExpect(jsonPath("$[0].engineering").exists());
        mockMvc.perform(get("/products/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].category").exists())
                .andExpect(jsonPath("$[0].price").exists());
    }

    @Test void invalidCountsReturnBadRequest() throws Exception {
        mockMvc.perform(get("/users/0")).andExpect(status().isBadRequest());
        mockMvc.perform(get("/products/1001")).andExpect(status().isBadRequest());
    }
}
