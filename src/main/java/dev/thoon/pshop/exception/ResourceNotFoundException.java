package dev.thoon.pshop.exception;

import jakarta.servlet.http.HttpServletResponse;

public class ResourceNotFoundException extends AbstractApplicationException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message, HttpServletResponse.SC_NOT_FOUND);
    }
}