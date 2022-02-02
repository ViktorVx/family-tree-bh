package org.pva.familytreebh.reopository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    String id;
    String lastName;
    String bornLastName;
    String firstName;
    String middleName;
    Date birthDate;
    Date deathDate;
    Person mother;
    Person father;
    String curriculumVitae;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    final Set<Person> children = new HashSet<>();
}
