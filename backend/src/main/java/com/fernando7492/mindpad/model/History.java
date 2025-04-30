package com.fernando7492.mindpad.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="history")
public class History {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="page_id", nullable=false, updatable=false)
    private Page page;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name="created_at",nullable=false)
    private LocalDateTime timestamp;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="author_id", nullable=true)
    private User author;
}
