package co.edu.taller6.cleanarchitecture.infrastructure.web;

import io.swagger.v3.oas.annotations.Hidden;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Provides a discoverable response at the API context root. */
@RestController
@Hidden
public class ApiIndexController {
    /**
     * Lists the available API resources and documentation endpoints.
     *
     * @return An HTTP 200 JSON response for requests to `/api/`.
     */
    @GetMapping({"", "/"})
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Clean Architecture Spring Boot API");
        body.put("endpoints", Map.of(
                "users", "/api/users/{countUsers}",
                "products", "/api/products/{countProducts}",
                "categories", "/api/categories"));
        body.put("swaggerUi", "/api/swagger-ui.html");
        body.put("openApi", "/api/v3/api-docs");
        return ResponseEntity.ok(body);
    }
}
