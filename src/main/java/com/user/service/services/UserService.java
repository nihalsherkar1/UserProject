package com.user.service.services;

import com.user.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getAllUsers();

    User updateUser(User  user, Integer id);

    String deleteUserById(Integer id);

    User getUserById(Integer id);

    List<User> getUsersByDepartment(String department);

}
