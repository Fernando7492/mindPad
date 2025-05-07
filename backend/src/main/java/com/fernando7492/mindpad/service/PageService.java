package com.fernando7492.mindpad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fernando7492.mindpad.dto.PageSearchDTO;
import com.fernando7492.mindpad.exception.PageNotFoundException;
import com.fernando7492.mindpad.model.Page;
import com.fernando7492.mindpad.repository.PagesRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PageService {
    private final PagesRepository pagesRepository;
    @PersistenceContext
    private EntityManager entityManager;

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

    public List<Page> search(PageSearchDTO searchDTO){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Page> cq = cb.createQuery(Page.class);
        Root<Page> pageRoot = cq.from(Page.class);

        List<Predicate> predicates = new ArrayList<>();

        if(searchDTO.getTitle() != null && !searchDTO.getTitle().isEmpty()){
            predicates.add(cb.like(cb.lower(pageRoot.get("title")), "%" + searchDTO.getTitle().toLowerCase() + "%"));
        }
        if(searchDTO.getContent() != null && !searchDTO.getContent().isEmpty()){
            predicates.add(cb.like(cb.lower(pageRoot.get("content")), "%" + searchDTO.getContent().toLowerCase() + "%"));
        }
        if (searchDTO.getAuthor() != null && !searchDTO.getAuthor().isEmpty()) {
            predicates.add(cb.like(cb.lower(pageRoot.get("author").get("name")), "%" + searchDTO.getAuthor().toLowerCase() + "%"));
        }
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(Predicate[]::new)));
        }

        return entityManager.createQuery(cq).getResultList();
        
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
