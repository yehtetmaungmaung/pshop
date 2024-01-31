package dev.thoon.pshop.model;

public class OrderStatus {
    
    private Long count;

    private String message;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
