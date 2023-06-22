package com.swift.model;

import org.springframework.http.HttpStatusCode;


public class ModelResponse {
    
    private HttpStatusCode httpStatusCode;
    private Object body;
    private String message;

    public ModelResponse withHttpStatusCode(HttpStatusCode httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    public ModelResponse withBody(Object body) {
        this.body = body;
        return this;
    }

    public ModelResponse withMessage(String message) {
        this.message = message;
        return this;
    }
}
