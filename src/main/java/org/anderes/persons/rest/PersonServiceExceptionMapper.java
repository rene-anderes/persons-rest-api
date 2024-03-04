package org.anderes.persons.rest;

import org.anderes.persons.domain.PersonServiceException;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.PrintWriter;
import java.io.StringWriter;

@Provider
public class PersonServiceExceptionMapper implements ExceptionMapper<PersonServiceException> {

    private static final Response.Status STATUS_CODE = Response.Status.INTERNAL_SERVER_ERROR;
    private final StatisticsService statisticsService;

    @Inject
    public PersonServiceExceptionMapper(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public Response toResponse(PersonServiceException exception) {

        final var stringWriter = new StringWriter();
        final var printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        
        statisticsService.addError(STATUS_CODE.getStatusCode(), stringWriter.toString());
        return Response.status(STATUS_CODE).entity("Fehler: " + stringWriter).type(MediaType.TEXT_PLAIN).build();
    }

}
