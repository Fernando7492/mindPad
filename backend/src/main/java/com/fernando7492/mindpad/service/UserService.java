package com.fernando7492.mindpad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.exception.UserNotFoundException;
import com.fernando7492.mindpad.model.User;
import com.fernando7492.mindpad.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Create
    public User save(User user){
        return userRepository.save(user);
    }
    //Read
    public List<User> listAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findByName(String name){
        return userRepository.findByNameContainingIgnoreCase(name);
    }
    //Update
    public User update(User user){
        return userRepository.save(user);
    }
    //Delete
    public void deleteById(Long id) throws UserNotFoundException{
        if (!userRepository.existById(id)){
            throw new UserNotFoundException();
        }else{
            userRepository.deleteById(id);
        }
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
