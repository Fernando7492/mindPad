package com.fernando7492.mindpad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.exception.PageNotFoundException;
import com.fernando7492.mindpad.model.Page;
import com.fernando7492.mindpad.repository.PagesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagesService {
    private final PagesRepository pagesRepository;

    public Page save(Page page){
        return pagesRepository.save(page);
    }

    public List<Page> listaAll(){
        return pagesRepository.findAll();
    } 

    public Page findbyId(Long id){
        return pagesRepository.findById(id).
        orElseThrow();
    }

    public List<Page> findByContent(String content){
        return pagesRepository.findByContentContainingIgnoreCase(content);
    }
    public List<Page> findByTitle(String content){
        return pagesRepository.findByTitleContainingIgnoreCase(content);
    }

    public Page update(Page page){
        if (page.getId()==null || !pagesRepository.existsById(page.getId())){
            throw new PageNotFoundException(page.getId());
        }
        return pagesRepository.save(page);
    }

    public void delete(Page page){
        pagesRepository.delete(page);
    }

    public void deleteById(Long id){
        if(!pagesRepository.existsById(id)){
            throw new PageNotFoundException(id);
        }
        else{
            pagesRepository.deleteById(id);
        }
    }
}
