package org.anderes.persons;

import org.glassfish.jersey.server.ResourceConfig;


public class ApplicationConfig extends ResourceConfig {
    
    public ApplicationConfig() {
        register(new ApplicationBinder());
        packages("org.anderes.persons", "org.anderes.persons.rest");
    }
}
