package com.fernando7492.mindpad.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.dto.PageRequestDTO;
import com.fernando7492.mindpad.dto.PageResponseDTO;
import com.fernando7492.mindpad.dto.UserRequestDTO;
import com.fernando7492.mindpad.dto.UserResponseDTO;
import com.fernando7492.mindpad.mapper.PageMapper;
import com.fernando7492.mindpad.mapper.UserMapper;
import com.fernando7492.mindpad.model.Page;
import com.fernando7492.mindpad.model.User;
import com.fernando7492.mindpad.service.PageService;
import com.fernando7492.mindpad.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Mindpad {
    private final UserService userService;
    private final UserMapper userMapper;
    private final PageService pageService;
    private final PageMapper pageMapper;
    
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

    //Page
    public PageResponseDTO savePage(PageRequestDTO dto){
        Page saved = pageService.save(pageMapper.toEntity(dto));
        return pageMapper.toDto(saved);
    }

    public List<PageResponseDTO> getAllPages(){
        List<Page> entities = pageService.listaAll();
        return entities.stream()
        .map(pageMapper::toDto)
        .collect(Collectors.toList());
    }

    public PageResponseDTO findPageById(Long id){
        return pageMapper.toDto(pageService.findbyId(id));
    }

    public List<PageResponseDTO> findPageByTitle(String title){
        List<Page> entities = pageService.findByTitle(title);
        return entities.stream()
        .map(pageMapper::toDto)
        .collect(Collectors.toList());
    }
    public List<PageResponseDTO> findPageByContent(String content){
        List<Page> entities = pageService.findByContent(content);
        return entities.stream()
        .map(pageMapper::toDto)
        .collect(Collectors.toList());
    }

    public PageResponseDTO updatePage(Long id, PageRequestDTO dto){
        Page entity = pageMapper.toEntity(dto);
        entity.setId(id);
        Page saved = pageService.update(entity);
        PageResponseDTO response = pageMapper.toDto(saved);
        return response;
    }

    public void deletePage(Long id){
        pageService.deleteById(id);
    }

}
