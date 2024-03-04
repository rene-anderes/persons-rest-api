package org.anderes.persons.domain;

import java.io.Serial;

public class PersonValidationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    
    public PersonValidationException(String message, Exception exception) {
        super(message, exception);
    }
    
}
