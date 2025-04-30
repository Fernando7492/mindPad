package com.fernando7492.mindpad.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fernando7492.mindpad.dto.UserRequestDTO;
import com.fernando7492.mindpad.dto.UserResponseDTO;
import com.fernando7492.mindpad.facade.Midpad;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final Midpad mindpad;

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@Validated @RequestBody UserRequestDTO newUser){
        UserResponseDTO create = mindpad.saveUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @GetMapping
    public List<UserResponseDTO> getUsers(@RequestParam(required=false) String name){
        if(name==null){
            return  mindpad.getAllUsers();
        }
        return mindpad.findUserByName(name);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id){
        return mindpad.findUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Validated @RequestBody UserRequestDTO dto){
        UserResponseDTO update = mindpad.updateUser(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        mindpad.deleteUser(id);
    }
    
}
