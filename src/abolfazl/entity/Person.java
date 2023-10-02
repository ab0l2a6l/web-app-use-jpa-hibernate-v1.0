package abolfazl.entity;

import javax.persistence.*;

@Table(name = "person")
@Entity(name = "personEntity")
@NamedQuery(name = "x1" , query = "select o from personEntity o")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    @Column(name = "name",columnDefinition = "varchar(20)")
    private String name;

    @Column(name = "family",columnDefinition = "varchar(20)")
    private String family;

    public long getPersonId() {
        return personId;
    }

    public Person setPersonId(long personId) {
        this.personId = personId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
