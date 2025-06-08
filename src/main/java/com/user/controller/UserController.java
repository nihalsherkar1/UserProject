package com.user.controller;

import com.user.entity.User;
import com.user.service.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


@PostMapping("/add")
  public ResponseEntity<User> addUser(@RequestBody User user){
       User data=   userService.addUser(user);
       return new ResponseEntity<>(data, HttpStatus.CREATED);
  }

  @GetMapping("/all")
  @CacheEvict(key = "'allUsers'" , value = "usersCache")
    public ResponseEntity<?> getAllUser(){
        List<User> allUsers= userService.getAllUsers();
        return  new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> UpdateUser(@RequestBody User user, @PathVariable Integer id){
          User data=    userService.updateUser(user,id);
          return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id){
       String msg=  userService.deleteUserById(id);
       return  new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
         User data=   userService.getUserById(id);
         return  new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    @Cacheable(key = "'getUserByDept'"  , value = "#department")
    public ResponseEntity<List<User>> getUsersByDepartment(@PathVariable  String department){
        List<User> data=  userService.getUsersByDepartment(department);
        return  new ResponseEntity<>(data,HttpStatus.OK);
    }

}
