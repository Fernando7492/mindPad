package com.fernando7492.mindpad.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fernando7492.mindpad.dto.PageRequestDTO;
import com.fernando7492.mindpad.dto.PageResponseDTO;
import com.fernando7492.mindpad.dto.PageSearchDTO;
import com.fernando7492.mindpad.facade.Mindpad;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PageController {

    private final Mindpad mindpad;

    @PostMapping
    public ResponseEntity<PageResponseDTO> savePage(@Validated @RequestBody PageRequestDTO newPage){
        PageResponseDTO create = mindpad.savePage(newPage);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @GetMapping
    public List<PageResponseDTO> getPages(@RequestParam(required=false) String title){
        if(title==null){
            return mindpad.getAllPages();
        }
        return mindpad.findPageByTitle(title);
    }

    //TODO: Refatorar as buscas para um único metodo usando PageSearchDto

    @PostMapping("/search/content")
    public List<PageResponseDTO> getPagesByContent(@RequestBody PageSearchDTO dto){
        System.out.println("DEBUG >> Chegou no controller com content: " + dto.getContent());
        return mindpad.findPageByContent(dto.getContent());
    }

    @GetMapping("/{id}")
    public PageResponseDTO getPageById(@PathVariable Long id){
        return mindpad.findPageById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PageResponseDTO> updatePageEntity(@PathVariable Long id, @Validated @RequestBody PageRequestDTO dto){
        PageResponseDTO update = mindpad.updatePage(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(update);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePage(@PathVariable Long id){
        mindpad.deletePage(id);
    }
}
