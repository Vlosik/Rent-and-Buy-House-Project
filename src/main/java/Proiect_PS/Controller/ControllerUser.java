package Proiect_PS.Controller;

import Proiect_PS.Service.ServiceUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ControllerUser {
    private ServiceUser serviceUser;

    public ControllerUser(ServiceUser userService){
        this.serviceUser = userService;
    }
    @PostMapping("/insert")
    public void addUser(@RequestBody UserData userData){
       this.serviceUser.insertUser(userData);
    }
    @GetMapping("/findUser")
    public void findByUser(@RequestBody UserData userData){
        this.serviceUser.findUser(userData);
    }
    @DeleteMapping ("/delete")
    public void deleteUser(@RequestBody UserData userData){
        this.serviceUser.deleteUser(userData);
    }

    @PutMapping ("/update")
    public void updateUser(@RequestBody UserData userData){
        this.serviceUser.updateUser(userData);
    }
}
