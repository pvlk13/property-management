package com.project.project_management.exception;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class BusinessException extends Exception{
    private List<ErrorModel> errors;
    public BusinessException(List<ErrorModel> errors){
        this.errors = errors;
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
