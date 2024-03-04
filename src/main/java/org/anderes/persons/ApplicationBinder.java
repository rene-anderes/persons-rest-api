package org.anderes.persons;

import javax.inject.Singleton;

import org.anderes.persons.domain.PersonServiceMem;
import org.anderes.persons.domain.StatisticsServiceMem;
import org.anderes.persons.rest.PersonService;
import org.anderes.persons.rest.StatisticsService;
import org.glassfish.jersey.internal.inject.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {
    
    @Override
    protected void configure() {
        bind(PersonServiceMem.class).to(PersonService.class).in(Singleton.class);
        bind(StatisticsServiceMem.class).to(StatisticsService.class).in(Singleton.class);
    }
}
