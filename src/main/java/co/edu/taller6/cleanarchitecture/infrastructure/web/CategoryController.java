package co.edu.taller6.cleanarchitecture.infrastructure.web;

import co.edu.taller6.cleanarchitecture.application.usecase.GetAllCategoriesUseCase;
import co.edu.taller6.cleanarchitecture.domain.model.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Categories")
public class CategoryController {
    private final GetAllCategoriesUseCase useCase;
    public CategoryController(GetAllCategoriesUseCase useCase) { this.useCase = useCase; }

    @GetMapping("/categories")
    @Operation(summary = "Obtener categorías del catálogo", responses = @ApiResponse(responseCode = "200", description = "Categorías disponibles"))
    public ResponseEntity<List<Category>> getAll() { return ResponseEntity.ok(useCase.execute()); }
}
