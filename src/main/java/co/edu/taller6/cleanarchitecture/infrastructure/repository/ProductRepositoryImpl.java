package co.edu.taller6.cleanarchitecture.infrastructure.repository;

import co.edu.taller6.cleanarchitecture.domain.model.Product;
import co.edu.taller6.cleanarchitecture.domain.repository.ProductRepository;
import co.edu.taller6.cleanarchitecture.infrastructure.datasource.ProductDataSource;
import java.util.List;

/** Infrastructure adapter from the product datasource to the domain port. */
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductDataSource dataSource;
    public ProductRepositoryImpl(ProductDataSource dataSource) { this.dataSource = dataSource; }
    @Override public List<Product> findAll(int countProducts) { return dataSource.getAll(countProducts); }
}
