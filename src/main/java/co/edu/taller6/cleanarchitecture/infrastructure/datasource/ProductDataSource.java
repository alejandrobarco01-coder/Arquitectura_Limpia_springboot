package co.edu.taller6.cleanarchitecture.infrastructure.datasource;

import co.edu.taller6.cleanarchitecture.domain.model.Product;
import java.util.List;
import java.util.stream.IntStream;

/** In-memory datasource used for the workshop API. */
public class ProductDataSource {
    private static final String[] CATEGORIES = {"Carnes", "Frutas", "Lacteos", "Verduras"};

    public List<Product> getAll(int countProducts) {
        return IntStream.rangeClosed(1, countProducts)
                .mapToObj(index -> new Product((long) index, "Producto " + index,
                        CATEGORIES[(index - 1) % CATEGORIES.length], Double.parseDouble(String.format(java.util.Locale.ROOT, "%.2f", 10 + index * 3.75))))
                .toList();
    }
}
