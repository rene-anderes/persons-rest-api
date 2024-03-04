package org.anderes.persons.rest;

import org.anderes.persons.domain.PersonValidationException;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.PrintWriter;
import java.io.StringWriter;

@Provider
public class PersonValidationExceptionMapper implements ExceptionMapper<PersonValidationException> {

    private static final Response.Status STATUS_CODE = Response.Status.BAD_REQUEST;
    private final StatisticsService statisticsService;

    @Inject
    public PersonValidationExceptionMapper(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public Response toResponse(PersonValidationException exception) {
        
        final var stringWriter = new StringWriter();
        final var printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        
        statisticsService.addError(STATUS_CODE.getStatusCode(), stringWriter.toString());
        return Response.status(STATUS_CODE).entity("Fehler: " + stringWriter).type(MediaType.TEXT_PLAIN).build();
    }

}
