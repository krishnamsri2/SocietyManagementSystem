package com.example.ProjectLatest.to;

public class RestRequest<T> {
    private Token token;
    private T requestObject;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public T getRequestObject() {
        return requestObject;
    }

    public void setRequestObject(T requestObject) {
        this.requestObject = requestObject;
    }
}
