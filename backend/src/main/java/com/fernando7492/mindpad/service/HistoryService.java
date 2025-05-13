package com.fernando7492.mindpad.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.model.History;
import com.fernando7492.mindpad.model.Page;
import com.fernando7492.mindpad.repository.HistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final PageService pageService;

    public  void save(Page page){
        History history = new History();
        history.setPage(page);
        history.setTitle(page.getTitle());
        history.setContent(page.getContent());
        history.setAuthor(page.getAuthor());
        history.setTimestamp(LocalDateTime.now());

        historyRepository.save(history);
    }

    public List<History> getHistories(Long id){
        pageService.checkExistence(id);
        return historyRepository.findByPageIdOrderByTimestampDesc(id);
    }

}
