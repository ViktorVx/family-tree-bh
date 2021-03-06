package org.pva.familytreebh.reopository;

import lombok.Getter;
import org.pva.familytreebh.reopository.model.Person;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Getter
public class InMemoryTestDB {

    public static final String PERSON_STORAGE = "person";

    public final Map<String, Set<Object>> storage = new HashMap<>();

    public InMemoryTestDB() {
        storage.put(PERSON_STORAGE, new HashSet<>());
        Person pva = Person.builder()
                .id(UUID.randomUUID().toString())
                .lastName("Stone")
                .firstName("Viktor")
                .middleName("A")
                .build();
        Person pus = Person.builder()
                .id(UUID.randomUUID().toString())
                .lastName("Stone")
                .firstName("Julia")
                .middleName("S")
                .build();
        Person pav = Person.builder()
                .id(UUID.randomUUID().toString())
                .lastName("Stone")
                .firstName("Arthur")
                .middleName("V")
                .build();
        pav.setMother(pus);
        pav.setFather(pva);

        Person pgv = Person.builder()
                .id(UUID.randomUUID().toString())
                .lastName("Stone")
                .firstName("Herman")
                .middleName("V")
                .build();
        pgv.setMother(pus);
        pgv.setFather(pva);

        pva.getChildren().addAll(Set.of(pav, pgv));
        pus.getChildren().addAll(Set.of(pav, pgv));

        storage.get(PERSON_STORAGE).addAll(Set.of(pva, pus, pav, pgv));
    }
}
