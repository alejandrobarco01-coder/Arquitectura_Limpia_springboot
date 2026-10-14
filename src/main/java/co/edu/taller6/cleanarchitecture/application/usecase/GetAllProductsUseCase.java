package co.edu.taller6.cleanarchitecture.application.usecase;

import co.edu.taller6.cleanarchitecture.domain.model.Product;
import co.edu.taller6.cleanarchitecture.domain.repository.ProductRepository;
import java.util.List;

/** Application use case; it only depends on the domain port. */
public class GetAllProductsUseCase {
    private final ProductRepository repository;
    public GetAllProductsUseCase(ProductRepository repository) { this.repository = repository; }
    public List<Product> execute(int countProducts) { return repository.findAll(countProducts); }
}
