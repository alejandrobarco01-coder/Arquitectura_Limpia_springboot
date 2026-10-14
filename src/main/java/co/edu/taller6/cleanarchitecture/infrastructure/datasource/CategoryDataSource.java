package co.edu.taller6.cleanarchitecture.infrastructure.datasource;

import co.edu.taller6.cleanarchitecture.domain.model.Category;
import java.util.List;

/** In-memory datasource for the fixed category catalog. */
public class CategoryDataSource {
    public List<Category> getAll() {
        return List.of(
                new Category(1L, "Carnes", "Carnes y proteínas"),
                new Category(2L, "Frutas", "Frutas frescas"),
                new Category(3L, "Lacteos", "Leches y derivados"),
                new Category(4L, "Verduras", "Verduras y hortalizas"));
    }
}
