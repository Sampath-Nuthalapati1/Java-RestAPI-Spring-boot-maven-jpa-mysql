package com.sam.app.rest.Controller;

import com.sam.app.rest.Models.User;
import com.sam.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    @PostMapping(value = "/saveUser")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@RequestBody User user, @PathVariable long id) {
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setOccupation(user.getOccupation());
        updateUser.setAge(user.getAge());
        userRepo.save(updateUser);
        return "updated...";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "deleted...";
    }
}
