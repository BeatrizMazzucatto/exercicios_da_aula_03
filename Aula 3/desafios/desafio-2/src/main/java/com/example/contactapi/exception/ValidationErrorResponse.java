package com.example.contactapi.exception;

public class ValidationErrorResponse {
    
    private String erro;
    
    public ValidationErrorResponse() {
    }
    
    public ValidationErrorResponse(String erro) {
        this.erro = erro;
    }
    
    public String getErro() {
        return erro;
    }
    
    public void setErro(String erro) {
        this.erro = erro;
    }
}
