package com.fernando7492.mindpad.exception;

public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(Long id){
        super("Page Not Found with id "+id);
    }
}
