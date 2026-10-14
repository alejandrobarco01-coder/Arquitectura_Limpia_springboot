package co.edu.taller6.cleanarchitecture.infrastructure.web;

import co.edu.taller6.cleanarchitecture.application.usecase.GetAllUsersUseCase;
import co.edu.taller6.cleanarchitecture.domain.model.User;
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
@Tag(name = "Users")
public class UserController {
    private final GetAllUsersUseCase useCase;
    public UserController(GetAllUsersUseCase useCase) { this.useCase = useCase; }

    @GetMapping("/users/{countUsers}")
    @Operation(summary = "Obtener listado de usuarios", responses = {@ApiResponse(responseCode = "200", description = "Usuarios generados"), @ApiResponse(responseCode = "400", description = "Cantidad inválida")})
    public ResponseEntity<List<User>> getAll(@Parameter(description = "Cantidad entre 1 y 1000") @PathVariable int countUsers) {
        validate(countUsers, "countUsers");
        return ResponseEntity.ok(useCase.execute(countUsers));
    }
    private void validate(int count, String name) { if (count < 1 || count > 1000) throw new IllegalArgumentException(name + " debe ser un entero entre 1 y 1000."); }
}
