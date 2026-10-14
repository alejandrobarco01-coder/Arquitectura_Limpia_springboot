package co.edu.taller6.cleanarchitecture.infrastructure.datasource;

import co.edu.taller6.cleanarchitecture.domain.model.User;
import java.util.List;
import java.util.stream.IntStream;

/** In-memory datasource used for the workshop API. */
public class UserDataSource {
    private static final String[] NAMES = {"Ana", "Carlos", "Laura", "Mateo", "Sofía", "Juan"};
    private static final String[] LAST_NAMES = {"García", "Ramírez", "López", "Martínez", "Torres", "Pérez"};
    private static final String[] ENGINEERING = {"Sistemas", "Electronica", "Biomedica", "Industrial", "Ambiental"};

    public List<User> getAll(int countUsers) {
        return IntStream.rangeClosed(1, countUsers)
                .mapToObj(index -> new User((long) index, NAMES[(index - 1) % NAMES.length],
                        LAST_NAMES[(index - 1) % LAST_NAMES.length], 18 + ((index * 7) % 48),
                        "usuario" + index + "@example.com", ENGINEERING[(index - 1) % ENGINEERING.length]))
                .toList();
    }
}
