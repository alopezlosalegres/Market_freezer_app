package com.gt.marketfreezer.model;

import java.util.List;

public class ResponseGenericProduct {
    public int statusCode;
    public String message;
    public List<Product> body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getBody() {
        return body;
    }

    public void setBody(List<Product> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResponseGenericProduct{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
