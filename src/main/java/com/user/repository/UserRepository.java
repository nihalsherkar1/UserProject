package com.user.repository;

import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

    @Procedure(name = "User.getUsersByDepartment")
    @Query("SELECT d FROM User as d WHERE d.department = :dept ")
    List<User>getUserByDepartment(@Param("dept") String department);



}
