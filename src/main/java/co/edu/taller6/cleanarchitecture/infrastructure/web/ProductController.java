package co.edu.taller6.cleanarchitecture.infrastructure.web;

import co.edu.taller6.cleanarchitecture.application.usecase.GetAllProductsUseCase;
import co.edu.taller6.cleanarchitecture.domain.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Products")
public class ProductController {
    private final GetAllProductsUseCase useCase;
    public ProductController(GetAllProductsUseCase useCase) { this.useCase = useCase; }

    @GetMapping("/products/{countProducts}")
    @Operation(summary = "Obtener listado de productos", responses = {@ApiResponse(responseCode = "200", description = "Productos generados"), @ApiResponse(responseCode = "400", description = "Cantidad inválida")})
    public ResponseEntity<List<Product>> getAll(@Parameter(description = "Cantidad entre 1 y 1000") @PathVariable int countProducts) {
        if (countProducts < 1 || countProducts > 1000) throw new IllegalArgumentException("countProducts debe ser un entero entre 1 y 1000.");
        return ResponseEntity.ok(useCase.execute(countProducts));
    }
}
