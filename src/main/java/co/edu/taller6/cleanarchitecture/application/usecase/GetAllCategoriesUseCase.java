package co.edu.taller6.cleanarchitecture.application.usecase;

import co.edu.taller6.cleanarchitecture.domain.model.Category;
import co.edu.taller6.cleanarchitecture.domain.repository.CategoryRepository;
import java.util.List;

/** Application use case for the fixed catalog. */
public class GetAllCategoriesUseCase {
    private final CategoryRepository repository;
    public GetAllCategoriesUseCase(CategoryRepository repository) { this.repository = repository; }
    public List<Category> execute() { return repository.findAll(); }
}
