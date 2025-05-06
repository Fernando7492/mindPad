package com.fernando7492.mindpad.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fernando7492.mindpad.dto.PageRequestDTO;
import com.fernando7492.mindpad.dto.PageResponseDTO;
import com.fernando7492.mindpad.model.Page;

@Component
public class PageMapper {
    private final ModelMapper modelMapper;

    public PageMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Page toEntity(PageRequestDTO dto){
        return modelMapper.map(dto, Page.class);
    }

    public PageResponseDTO toDto(Page page){
        return  modelMapper.map(page, PageResponseDTO.class);
    }

}
