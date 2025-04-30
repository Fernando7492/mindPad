package com.fernando7492.mindpad.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fernando7492.mindpad.dto.UserRequestDTO;
import com.fernando7492.mindpad.dto.UserResponseDTO;
import com.fernando7492.mindpad.model.User;


@Component
public class UserMapper {
    private final  ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public User toEntity(UserRequestDTO dto){
        return modelMapper.map(dto, User.class);
    }

    public UserResponseDTO toDTO(User user){
        return modelMapper.map(user, UserResponseDTO.class);
    }
}
