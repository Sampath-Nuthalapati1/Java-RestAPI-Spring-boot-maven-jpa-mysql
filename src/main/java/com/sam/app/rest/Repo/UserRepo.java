package com.sam.app.rest.Repo;

import com.sam.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface UserRepo extends JpaRepository<User, Long> {

    @Procedure(value = "sp_addUser", outputParameterName = "status")
    public boolean addUser(int age, String firstname, String lastname, String occcupation);
}
