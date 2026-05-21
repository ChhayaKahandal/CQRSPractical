package com.cqrs.CqrsPractical.exception;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
