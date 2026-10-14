package co.edu.taller6.cleanarchitecture.domain.repository;

import co.edu.taller6.cleanarchitecture.domain.model.Category;
import java.util.List;

/** Output port for obtaining catalog categories. */
public interface CategoryRepository {
    List<Category> findAll();
}
