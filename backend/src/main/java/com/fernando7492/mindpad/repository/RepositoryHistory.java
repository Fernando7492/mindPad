package com.fernando7492.mindpad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando7492.mindpad.model.History;

@Repository
public interface RepositoryHistory extends JpaRepository<History, Long>{

}
