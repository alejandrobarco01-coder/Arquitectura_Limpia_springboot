package co.edu.taller6.cleanarchitecture.application.usecase;

import co.edu.taller6.cleanarchitecture.domain.model.User;
import co.edu.taller6.cleanarchitecture.domain.repository.UserRepository;
import java.util.List;

/** Application use case; it only depends on the domain port. */
public class GetAllUsersUseCase {
    private final UserRepository repository;
    public GetAllUsersUseCase(UserRepository repository) { this.repository = repository; }
    public List<User> execute(int countUsers) { return repository.findAll(countUsers); }
}
