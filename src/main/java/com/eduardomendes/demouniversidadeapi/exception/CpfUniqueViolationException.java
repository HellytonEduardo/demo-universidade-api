package com.eduardomendes.demouniversidadeapi.exception;

public class CpfUniqueViolationException extends RuntimeException{
    public CpfUniqueViolationException(String message){
        super(message);
    }
}
