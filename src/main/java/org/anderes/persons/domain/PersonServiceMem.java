package org.anderes.persons.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.anderes.persons.rest.PersonService;
import org.xml.sax.SAXException;

public class PersonServiceMem implements PersonService {
    
    private final List<Person> personCollection;
    
    @Inject
    public PersonServiceMem() {
        personCollection = new ArrayList<>();
    }

    @Override
    public Persons getPersons() {
        final var factory = new ObjectFactory();
        final var persons = factory.createPersons();
        persons.getPerson().addAll(personCollection);
        return persons;
    }

    @Override
    public int save(Persons persons) {
        validate(persons);
        personCollection.addAll(persons.person);
        return personCollection.size();
    }

    void validate(Persons persons) {
        try {
            final var isSchema = Persons.class.getResourceAsStream("fullstack-backend-challenge.xsd");
            final var schemaSource = new StreamSource(isSchema);
            final var context = JAXBContext.newInstance(ObjectFactory.class.getPackageName(), ObjectFactory.class.getClassLoader());
            final var sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final var schema = sf.newSchema(schemaSource);
            final var source = new JAXBSource(context, persons);
            final var validator = schema.newValidator();
            validator.setErrorHandler(new ValidationErrorHandler());
            validator.validate(source);
        } catch (IOException | SAXException | JAXBException e) {
            throw new PersonServiceException(e);
        }
      }
}
