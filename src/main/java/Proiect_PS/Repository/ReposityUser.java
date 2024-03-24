package Proiect_PS.Repository;

import Proiect_PS.Model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;

/**
 * The ReposityUser interface extends the CrudRepository interface, providing CRUD (Create, Read, Update, Delete)
 * functionalities for User entity management. It includes custom methods for user-specific queries, such as finding
 * a user by their username.
 */
public interface ReposityUser extends CrudRepository<User,Long> {
    /**
     * Finds a user in the database by their username.
     * This method queries the database for a user entity with the specified username.
     *
     * @param username The username of the user to be found.
     * @return A User object if a user with the given username exists, otherwise null.
     */
    User findByUsername(String username);
}
