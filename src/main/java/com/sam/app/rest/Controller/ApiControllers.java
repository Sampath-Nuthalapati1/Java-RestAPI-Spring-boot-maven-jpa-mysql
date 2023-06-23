package com.sam.app.rest.Controller;

import com.sam.app.rest.Models.User;
import com.sam.app.rest.Repo.UserRepo;
import com.sam.app.rest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@RequestBody User user, @PathVariable long id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @PostMapping(value = "/addUser")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
