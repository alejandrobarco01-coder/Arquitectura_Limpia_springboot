package co.edu.taller6.cleanarchitecture.infrastructure.config;

import co.edu.taller6.cleanarchitecture.application.usecase.GetAllCategoriesUseCase;
import co.edu.taller6.cleanarchitecture.application.usecase.GetAllProductsUseCase;
import co.edu.taller6.cleanarchitecture.application.usecase.GetAllUsersUseCase;
import co.edu.taller6.cleanarchitecture.domain.repository.CategoryRepository;
import co.edu.taller6.cleanarchitecture.domain.repository.ProductRepository;
import co.edu.taller6.cleanarchitecture.domain.repository.UserRepository;
import co.edu.taller6.cleanarchitecture.infrastructure.datasource.CategoryDataSource;
import co.edu.taller6.cleanarchitecture.infrastructure.datasource.ProductDataSource;
import co.edu.taller6.cleanarchitecture.infrastructure.datasource.UserDataSource;
import co.edu.taller6.cleanarchitecture.infrastructure.repository.CategoryRepositoryImpl;
import co.edu.taller6.cleanarchitecture.infrastructure.repository.ProductRepositoryImpl;
import co.edu.taller6.cleanarchitecture.infrastructure.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Composition root: infrastructure implementations are wired to application use cases here. */
@Configuration
public class AppConfig {
    @Bean UserDataSource userDataSource() { return new UserDataSource(); }
    @Bean ProductDataSource productDataSource() { return new ProductDataSource(); }
    @Bean CategoryDataSource categoryDataSource() { return new CategoryDataSource(); }

    @Bean UserRepository userRepository(UserDataSource dataSource) { return new UserRepositoryImpl(dataSource); }
    @Bean ProductRepository productRepository(ProductDataSource dataSource) { return new ProductRepositoryImpl(dataSource); }
    @Bean CategoryRepository categoryRepository(CategoryDataSource dataSource) { return new CategoryRepositoryImpl(dataSource); }

    @Bean GetAllUsersUseCase getAllUsersUseCase(UserRepository repository) { return new GetAllUsersUseCase(repository); }
    @Bean GetAllProductsUseCase getAllProductsUseCase(ProductRepository repository) { return new GetAllProductsUseCase(repository); }
    @Bean GetAllCategoriesUseCase getAllCategoriesUseCase(CategoryRepository repository) { return new GetAllCategoriesUseCase(repository); }

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET");
            }
        };
    }
}
