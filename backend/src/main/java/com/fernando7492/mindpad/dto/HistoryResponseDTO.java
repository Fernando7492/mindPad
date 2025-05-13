package com.fernando7492.mindpad.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HistoryResponseDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime timestamp;
}
