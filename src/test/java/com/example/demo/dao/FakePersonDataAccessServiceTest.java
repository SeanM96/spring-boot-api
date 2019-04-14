package com.example.demo.dao;

import com.example.demo.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class FakePersonDataAccessServiceTest {

    private FakePersonDataAccessService underTest;

    @Before
    public void setUp() {
        underTest = new FakePersonDataAccessService();
    }

    @Test
    public void canPerformCrud() {
        UUID idOne = UUID.randomUUID();
        Person personOne = new Person(idOne, "Sean", "Sean", "a@b.com");

        UUID idTwo = UUID.randomUUID();
        Person personTwo = new Person(idTwo, "Amy", "Bacon", "a@b.com");

        underTest.insertPerson(idOne, personOne);
        underTest.insertPerson(idTwo, personTwo);

        assertThat(underTest.selectPersonById(idOne))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(personOne));

        assertThat(underTest.selectPersonById(idTwo))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(personTwo));

        List<Person> people = underTest.selectAllPeople();

        assertThat(people)
                .hasSize(2)
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(personOne, personTwo);

        Person personUpdate = new Person(idOne, "jake", "black", "a@b.com");

        assertThat(underTest.updatePersonById(idOne, personUpdate)).isEqualTo(1);

        assertThat(underTest.selectPersonById(idOne))
                .isPresent()
                .hasValueSatisfying(personFromDb -> assertThat(personFromDb).isEqualToComparingFieldByField(personUpdate));

        assertThat(underTest.deletePersonByID(idOne)).isEqualTo(1);

        assertThat(underTest.selectPersonById(idOne)).isEmpty();

        assertThat(underTest.selectAllPeople())
                .hasSize(1)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(personTwo);
    }

    @Test
    public void willReturn0IfNoPersonFoundToDelete() {
        UUID id = UUID.randomUUID();

        int deleteResult = underTest.deletePersonByID(id);

        assertThat(deleteResult).isEqualTo(0);
    }

    @Test
    public void willReturn0IfNoPersonFoundToUpdate() {
        UUID id = UUID.randomUUID();
        Person person = new Person(id, "James Not in db", "we", "a@b.com");

        int deleteResult = underTest.updatePersonById(id, person);

        assertThat(deleteResult).isEqualTo(0);
    }

}
