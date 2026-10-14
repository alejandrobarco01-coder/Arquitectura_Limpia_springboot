package co.edu.taller6.cleanarchitecture.domain.repository;

import co.edu.taller6.cleanarchitecture.domain.model.User;
import java.util.List;

/** Output port for obtaining users. */
public interface UserRepository {
    List<User> findAll(int countUsers);
}
