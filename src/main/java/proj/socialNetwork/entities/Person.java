package proj.socialNetwork.entities;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "person")
@Table(
        name = "person",
        uniqueConstraints = {
                @UniqueConstraint(name = "person_login_constraint", columnNames = "login")
        }
)
@Check(constraints = "gender = 'Male' OR gender = 'Female'")
public class Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private UUID uuid;
    @Column(
            name = "login",
            unique = true,
            nullable = false
    )
    private String login;
    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    @Column(
            name = "gender",
            nullable = false
    )
    private String gender;
    @Column(
            name = "dob",
            nullable = false
    )
    private LocalDate dob;

    public Person() {}

    public Person(UUID uuid, String login, String firstName, String lastName, String email, String gender, LocalDate dob) {
        this.login = Objects.requireNonNull(login);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.email = Objects.requireNonNull(email);
        this.gender = Objects.requireNonNull(gender);
        this.dob = Objects.requireNonNull(dob);
        this.uuid = Objects.requireNonNull(uuid);
    }

    public Person(String login, String firstName, String lastName, String email, String gender, LocalDate dob) {
        this(UUID.randomUUID(),
                login,
                firstName,
                lastName,
                email,
                gender,
                dob);
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID generateUuid() {
        return UUID.randomUUID();
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public static String toString(Person person) {
        return "Person{" +
                "uuid=" + person.getUuid().toString() +
                ", login='" + person.getLogin().toString() + '\'' +
                ", firstName='" + person.getFirstName().toString() + '\'' +
                ", lastName='" + person.getLastName().toString() + '\'' +
                ", email='" + person.getEmail().toString() + '\'' +
                ", gender='" + person.getGender().toString() + '\'' +
                ", dob=" + person.getDob().toString() + '}';
    }

}