package proj.socialNetwork.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import proj.socialNetwork.Person;
import java.util.Optional;
import java.util.UUID;

public class PersonJdbcDAO {

    static RowMapper<Person> rowMapper = (rs, rowNum) -> new Person((UUID) rs.getObject("uuid"),
            rs.getString("login"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("email"),
            rs.getString("gender"),
            (rs.getDate("dob")).toLocalDate());

    public static void create(Person person, JdbcTemplate jdbcTemplate) {
        var sql = "INSERT INTO person (uuid, login, first_name, last_name, email, gender, dob) VALUES (?,?,?,?,?,?,?)";
        var create = jdbcTemplate.update(
                sql,
                person.getUuid(),
                person.getLogin(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getGender(),
                person.getDob());
        if (create == 1)
            System.out.println("New person created");
    }

    public static Optional<Person> get(UUID uuid, JdbcTemplate jdbcTemplate) {
        var sql = "SELECT uuid, login, first_name, last_name, email, gender, dob FROM person WHERE uuid = ?";
        Person person = null;
        try {
            person = jdbcTemplate.queryForObject(sql, new Object[]{uuid}, rowMapper);
        } catch (DataAccessException e) {
            System.out.println("Person if not found");
        }
        return Optional.ofNullable(person);
    }

    public static void update(Person person, UUID uuid, JdbcTemplate jdbcTemplate) {
        var sql = "UPDATE person SET login = ?, first_name = ?, last_name = ?, email = ?, gender = ?, dob = ? where uuid = ?";
        var update = jdbcTemplate.update(sql, uuid,
                person.getLogin(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getGender(),
                person.getDob());
        if (update == 1)
            System.out.println("New person settled");
    }

    public static void remove(UUID uuid, JdbcTemplate jdbcTemplate) {
        var sql = "DELETE FROM person WHERE uuid = ?";
        var remove = jdbcTemplate.update(sql, uuid);
        if (remove == 1)
            System.out.println("Subscription was removed");
    }

}



