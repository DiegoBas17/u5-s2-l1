package com.example.diegobasili.exeptions;

public class NotFoudException extends RuntimeException {
    public NotFoudException(int id) {
        super("Elemento con id: " + id + " non trovato");
    }
}
