package com.fernando7492.mindpad.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
@Table(name="pages")
public class Page {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String title;
    
    @Lob
    private String content;
    
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="author_id", nullable=true)
    private User author;

    @Version
    private Long version;

    @OneToMany( mappedBy="page",
                cascade=CascadeType.ALL,
                orphanRemoval=true,
                fetch=FetchType.LAZY)
    private List<History> history = new ArrayList<>();

    @PrePersist
    public void setCreationtime(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateTime(){
        this.updatedAt = LocalDateTime.now();
    }
}
