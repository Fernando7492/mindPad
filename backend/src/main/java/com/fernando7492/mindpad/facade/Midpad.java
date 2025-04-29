package com.fernando7492.mindpad.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.model.User;
import com.fernando7492.mindpad.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Midpad {
    private final UserService userService;
    
    // USER
    public User saveUser(User user){
        return userService.save(user);       
    }

    public List<User> listAllUsers(){
    return userService.listAll();
    } 

    public User findUser(Long id){
        return userService.findById(id);
    }
    public List<User> findUser(String name){
        return userService.findByName(name);
    }

    public User updateUser(User user){
        return userService.update(user);
    }

    public void deleteUser(Long id){
        userService.deleteById(id);
    }


}
