package com.gt.marketfreezer.model;

public class ResponseGenericUsuario {
    public int statusCode;
    public String message;
    public BodyUsuario body;

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

    public BodyUsuario getBody() {
        return body;
    }

    public void setBody(BodyUsuario body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResponseGeneric{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
