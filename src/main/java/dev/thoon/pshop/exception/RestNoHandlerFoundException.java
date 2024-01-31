package dev.thoon.pshop.exception;


public class RestNoHandlerFoundException extends AbstractApplicationException {

    public RestNoHandlerFoundException(String s, int code) {
        super(s, code);
    }

    public RestNoHandlerFoundException(Throwable cause, int code) {
        super(cause, code);
    }

    public RestNoHandlerFoundException(String message, Throwable cause, int code) {
        super(message, cause, code);
    }
}