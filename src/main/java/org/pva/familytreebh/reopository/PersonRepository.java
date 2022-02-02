package org.pva.familytreebh.reopository;

import lombok.RequiredArgsConstructor;
import org.pva.familytreebh.reopository.model.Person;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.pva.familytreebh.reopository.InMemoryTestDB.PERSON_STORAGE;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private final InMemoryTestDB inMemoryTestDB;

    public Set<Person> getAll() {
        return inMemoryTestDB.getStorage()
                .get(PERSON_STORAGE)
                .stream()
                .map(p -> (Person) p)
                .collect(Collectors.toSet());
    }

    public Optional<Person> getById(String id) {
        return getAll().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Optional<Person> getByFullName(String lastName, String firstName, String middleName, Date birthDate) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return getAll().stream()
                .filter(p -> p.getLastName().equals(lastName)
                        && p.getFirstName().equals(firstName)
                        && p.getMiddleName().equals(middleName)
                        && fmt.format(p.getBirthDate()).equals(fmt.format(birthDate)))
                .findFirst();
    }

    public Set<Person> getByFullName(String lastName, String firstName, String middleName) {
        return getAll().stream()
                .filter(p -> p.getLastName().equals(lastName)
                        && p.getFirstName().equals(firstName)
                        && p.getMiddleName().equals(middleName))
                .collect(Collectors.toSet());
    }

}
