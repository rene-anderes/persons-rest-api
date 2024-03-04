package org.anderes.persons.domain;

public class PersonValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public PersonValidationException(String message, Exception exception) {
        super(message, exception);
    }
    
}
