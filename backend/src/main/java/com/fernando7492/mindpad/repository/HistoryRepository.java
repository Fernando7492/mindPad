package com.fernando7492.mindpad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando7492.mindpad.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

    List<History> findByPageIdOrderByTimestampsDesc(Long ParentId);

}
