package org.anderes.persons.domain;

import java.io.Serial;

public class PersonServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public PersonServiceException(Exception exception) {
        super(exception);
    }
}
