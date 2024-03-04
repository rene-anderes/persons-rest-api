package ch.anderes.persons.domain;

import org.anderes.persons.domain.PersonServiceMem;
import org.anderes.persons.domain.PersonValidationException;
import org.anderes.persons.domain.generated.ObjectFactory;
import org.anderes.persons.domain.generated.Persons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class TestPersonServiceMem {

    private PersonServiceMem service;

    @BeforeEach
    void setup() {
        service = new PersonServiceMem();
    }

    @Test
    void shouldBeSavePersons() {
        // given
        final var persons = createOkayPersons();

        // when
        final var result = service.save(persons);

        // then
        assertEquals(1, result);
    }

    @Test
    void shouldBeNotSavePersons() {
        // given
        final var persons = createWrongPersons();

        // when
        final var exception = assertThrows(PersonValidationException.class, () -> service.save(persons));

        // then
        assertTrue(exception.getMessage().startsWith("cvc-enumeration-valid: Wert 't'"));

    }

    private Persons createWrongPersons() {
        final var factory = new ObjectFactory();
        final var persons = factory.createPersons();
        final var person = factory.createPerson();
        person.setName("Hans Müller");
        person.setAge(BigInteger.TEN);
        person.setGender("t");
        persons.getPerson().add(person);
        return persons;
    }

    private Persons createOkayPersons() {
        final var factory = new ObjectFactory();
        final var persons = factory.createPersons();
        final var person = factory.createPerson();
        person.setName("Hans Müller");
        person.setAge(BigInteger.TEN);
        person.setGender("m");
        persons.getPerson().add(person);
        return persons;
    }
}
