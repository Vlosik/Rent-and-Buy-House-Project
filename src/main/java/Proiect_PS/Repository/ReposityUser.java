package Proiect_PS.Repository;

import Proiect_PS.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ReposityUser extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
