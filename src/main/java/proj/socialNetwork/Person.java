package proj.socialNetwork;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


public class Person {

    private final UUID uuid;
    private final String login;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final LocalDate dob;

    public Person(UUID uuid, String login, String firstName, String lastName, String email, String gender, LocalDate dob){
        this.login = Objects.requireNonNull(login);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.email = Objects.requireNonNull(email);
        this.gender = Objects.requireNonNull(gender);
        this.dob = Objects.requireNonNull(dob);
        this.uuid = Objects.requireNonNull(uuid);
    }

    public Person(String login, String firstName, String lastName, String email, String gender, LocalDate dob){
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
