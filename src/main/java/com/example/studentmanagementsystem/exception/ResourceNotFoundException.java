package com.example.studentmanagementsystem.exception;

/**
 * Custom exception for cases where requested data is not available.
 * Used mainly when a student is not found by id.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
