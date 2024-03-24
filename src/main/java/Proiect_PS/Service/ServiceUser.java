package Proiect_PS.Service;

import Proiect_PS.Controller.UserData;
import Proiect_PS.Model.User;
import Proiect_PS.Repository.ReposityUser;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {
    private ReposityUser reposityUser;
    public ServiceUser(ReposityUser reposityUser){
        this.reposityUser = reposityUser;
    }

    public User insertUser(UserData userData){
        User user = new User();
        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());
        user.setEmail(userData.getEmail());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }

    public void deleteUser(UserData userData){
        User user = new User();
        user = findUser(userData);
        user.setPassword(userData.getPassword());
        user.setEmail(userData.getEmail());
        user.setRole(userData.getRole());
        reposityUser.delete(user);
    }

    public User updateUser(UserData userData){
        User user = findUser(userData);
        user.setUsername(userData.getUsername());
        user.setPassword(userData.getPassword());
        user.setEmail(userData.getEmail());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }

    public User findUser(UserData userData){
        User user = new User();
        user = reposityUser.findByUsername(userData.getUsername());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        return user;
    }
}
