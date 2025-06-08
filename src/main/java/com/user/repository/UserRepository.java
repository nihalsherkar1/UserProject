package com.user.repository;

import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository  extends JpaRepository<User, Integer> {

    @Procedure(name = "User.getUsersByDepartment")
    List<User>getUserByDepartment(@Param("dept") String department);
}
