package co.edu.taller6.cleanarchitecture.infrastructure.repository;

import co.edu.taller6.cleanarchitecture.domain.model.Category;
import co.edu.taller6.cleanarchitecture.domain.repository.CategoryRepository;
import co.edu.taller6.cleanarchitecture.infrastructure.datasource.CategoryDataSource;
import java.util.List;

/** Infrastructure adapter from the category datasource to the domain port. */
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryDataSource dataSource;
    public CategoryRepositoryImpl(CategoryDataSource dataSource) { this.dataSource = dataSource; }
    @Override public List<Category> findAll() { return dataSource.getAll(); }
}
