package com.fernando7492.mindpad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando7492.mindpad.model.Page;

@Repository
public interface PagesRepository extends JpaRepository<Page, Long>{

    
    List<Page> findByTitleContainingIgnoreCase(String title);

    List<Page> findByContentContainingIgnoreCase(String content);
}
