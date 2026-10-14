package co.edu.taller6.cleanarchitecture.infrastructure.repository;

import co.edu.taller6.cleanarchitecture.domain.model.User;
import co.edu.taller6.cleanarchitecture.domain.repository.UserRepository;
import co.edu.taller6.cleanarchitecture.infrastructure.datasource.UserDataSource;
import java.util.List;

/** Infrastructure adapter from the user datasource to the domain port. */
public class UserRepositoryImpl implements UserRepository {
    private final UserDataSource dataSource;
    public UserRepositoryImpl(UserDataSource dataSource) { this.dataSource = dataSource; }
    @Override public List<User> findAll(int countUsers) { return dataSource.getAll(countUsers); }
}
