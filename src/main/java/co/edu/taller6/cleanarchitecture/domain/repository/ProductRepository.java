package co.edu.taller6.cleanarchitecture.domain.repository;

import co.edu.taller6.cleanarchitecture.domain.model.Product;
import java.util.List;

/** Output port for obtaining products. */
public interface ProductRepository {
    List<Product> findAll(int countProducts);
}
