package com.user.service.serviceImpl;

import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user) ;
    }

    @Override
    @Procedure(name = "User.getAllUsers")
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUser(User user, Integer id) {
        // Here TrnasactionManager Session start here
       User existingUserFromDb=     userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given resouce with id: "+ id + " is not found !!!"));

       if(existingUserFromDb != null){
           existingUserFromDb.setUserName(user.getUserName());
           existingUserFromDb.setSalary(user.getSalary());
           existingUserFromDb.setDepartment(user.getDepartment());

           //           First Query start here
           userRepository.save(existingUserFromDb);
//           second query hit here
//           User returnUser =userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Given resouce with id: "+ id + " is not found !!!"));
            return existingUserFromDb;
       }
        return null;
//       Session closed here
    }

    @Override
    public String deleteUserById(Integer id) {
        User existingUserFromDb=     userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given resouce with id: "+ id + " is not found !!!"));

        if (existingUserFromDb != null){
            userRepository.deleteById(existingUserFromDb.getId());
            return  "Given user with id: "+ id + " is deleted successfully ...";
        }
        return "Something went wrong !!!";
    }

    @Override
    public User getUserById(Integer id) {
        User existingUserFromDb=     userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given resouce with id: "+ id + " is not found !!!"));
        return  existingUserFromDb;
    }

    @Override
    @Transactional
    public List<User> getUsersByDepartment(String department) {
        return userRepository.getUserByDepartment(department);
    }
}
