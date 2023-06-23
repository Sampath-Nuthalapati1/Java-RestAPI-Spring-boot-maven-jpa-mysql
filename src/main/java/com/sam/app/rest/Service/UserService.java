package com.sam.app.rest.Service;

import com.sam.app.rest.Models.User;
import com.sam.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "saved...";
    }

    public String updateUser(@RequestBody User user, @PathVariable long id) {
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setOccupation(user.getOccupation());
        updateUser.setAge(user.getAge());
        userRepo.save(updateUser);
        return "updated...";
    }

    public String deleteUser(long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "deleted...";
    }

    public boolean addUser(User user) {
        return userRepo.addUser(user.getAge(), user.getFirstName(), user.getLastName(), user.getOccupation());
    }


}
