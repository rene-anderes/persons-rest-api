package org.anderes.persons.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.anderes.persons.domain.Persons;
import org.anderes.persons.domain.Statistics;


@Path("/persons")
public class PersonController {

    private final PersonService personsService;
    private final StatisticsService statisticsService;

    @Inject
    public PersonController(PersonService personsService, StatisticsService statisticsService) {
        this.personsService = personsService;
        this.statisticsService = statisticsService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Persons showPersons() {
        final var persons = personsService.getPersons();
        statisticsService.incrementRequest();
        return persons;
    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addPersons(Persons persons) {
        final var total = personsService.save(persons);
        statisticsService.incrementAdd();
        statisticsService.getStatistics().setNumberOfPersons(total);
        return Response.ok().build();
    }
    
    @GET
    @Path("statistics")
    @Produces(MediaType.APPLICATION_JSON)
    public Statistics showStatistics() {
        return statisticsService.getStatistics();
    }
}