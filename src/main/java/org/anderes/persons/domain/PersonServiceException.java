package org.anderes.persons.domain;

public class PersonServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PersonServiceException(Exception exception) {
        super(exception);
    }
}
