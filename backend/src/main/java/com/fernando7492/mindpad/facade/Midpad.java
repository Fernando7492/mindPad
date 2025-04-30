package com.fernando7492.mindpad.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.dto.UserRequestDTO;
import com.fernando7492.mindpad.dto.UserResponseDTO;
import com.fernando7492.mindpad.mapper.UserMapper;
import com.fernando7492.mindpad.model.User;
import com.fernando7492.mindpad.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Midpad {
    private final UserService userService;
    private final UserMapper userMapper;
    
    // USER
    public UserResponseDTO saveUser(UserRequestDTO dto){
        User saved = userService.save(userMapper.toEntity(dto));
        return  userMapper.toDTO(saved);       
    }

    public List<UserResponseDTO> getAllUsers(){
        List<User> entities = userService.listAll();
        return entities.stream()
        .map(userMapper::toDTO)
        .collect(Collectors.toList());
        
    } 

    public UserResponseDTO findUserById(Long id){
        return userMapper.toDTO(userService.findById(id));
    }

    public List<UserResponseDTO> findUserByName(String name){
        List<User> entities = userService.findByName(name);
        return entities.stream()
        .map(userMapper::toDTO)
        .collect(Collectors.toList());
        }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto){
        User entity = userMapper.toEntity(dto);
        entity.setId(id);
        User saved = userService.update(entity);
        UserResponseDTO response = userMapper.toDTO(saved);
        return response;
    }

    public void deleteUser(Long id){
        userService.deleteById(id);
    }


}
