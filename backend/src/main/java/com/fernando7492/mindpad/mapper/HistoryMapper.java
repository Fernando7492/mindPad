package com.fernando7492.mindpad.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fernando7492.mindpad.dto.HistoryResponseDTO;
import com.fernando7492.mindpad.model.History;

@Component
public class HistoryMapper {
    
    private final ModelMapper modelMapper;

    public HistoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HistoryResponseDTO dto(History history){
        return modelMapper.map(history, HistoryResponseDTO.class);
    }

}
