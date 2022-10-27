package com.example.demo;

public class Response<T> {
    Integer status;
    String message;
    T dato;
    boolean error;

    public Response(){}

    public Response(Integer status, String message, T dato,boolean error) {
        this.status = status;
        this.message = message;
        this.dato = dato;
        this.error=error;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }
}