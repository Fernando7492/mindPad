package com.fernando7492.mindpad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.exception.UserNotFoundException;
import com.fernando7492.mindpad.model.User;
import com.fernando7492.mindpad.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //Create
    public User save(User user){
        return userRepository.save(user);
    }
    //Read
    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id)
        .orElseThrow(()-> new UserNotFoundException(id));
    }

    public List<User> findByName(String name){
        return userRepository.findByNameContainingIgnoreCase(name);
    }
    
    //Update
    public User update(User user){
        if (user.getId() == null || !userRepository.existsById(user.getId())){
            throw new UserNotFoundException(user.getId());
        }
        return  userRepository.save(user);
    }
    //Delete
    public void deleteById(Long id){
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }else{
            userRepository.deleteById(id);
        }
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
