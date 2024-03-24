package Proiect_PS.Service;

import Proiect_PS.Controller.UserData;
import Proiect_PS.Model.User;
import Proiect_PS.Repository.ReposityUser;
import org.springframework.stereotype.Service;
/**
 * The ServiceUser class provides user management services such as insertion, deletion,
 * updating, and finding users in the system. It interacts with the {@link ReposityUser} to
 * perform operations on the database.
 */
@Service
public class ServiceUser {
    private ReposityUser reposityUser;
    /**
     * Constructs a ServiceUser with a given user repository.
     *
     * @param reposityUser The user repository used for database operations.
     */
    public ServiceUser(ReposityUser reposityUser){
        this.reposityUser = reposityUser;
    }
    /**
     * Inserts a new user into the system based on the given user data.
     *
     * @param userData The data for the user to be inserted.
     * @return The inserted User object.
     */
    public User insertUser(UserData userData){
        User user = new User();
        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());
        user.setEmail(userData.getEmail());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }
    /**
     * Deletes an existing user from the system based on the given user data.
     *
     * @param userData The data for the user to be deleted.
     */
    public void deleteUser(UserData userData){
        User user = new User();
        user = findUser(userData);
        user.setPassword(userData.getPassword());
        user.setEmail(userData.getEmail());
        user.setRole(userData.getRole());
        reposityUser.delete(user);
    }
    /**
     * Updates an existing user's information in the system based on the given user data.
     *
     * @param userData The new data for the user to be updated.
     * @return The updated User object.
     */
    public User updateUser(UserData userData){
        User user = findUser(userData);
        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());
        user.setEmail(userData.getEmail());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }
    /**
     * Finds a user in the system based on the given user data.
     *
     * @param userData The data of the user to find.
     * @return The found User object, or null if the user does not exist.
     */
    public User findUser(UserData userData){
        User user = new User();
        user = reposityUser.findByUsername(userData.getUsername());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        return user;
    }
}
