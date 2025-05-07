package com.fernando7492.mindpad.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageSearchDTO {

    private Long Id;
    private String title;
    private String content;
    private String author;
    private String creatAt;
    private String updatedAt;
}
