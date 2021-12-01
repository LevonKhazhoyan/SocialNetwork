package proj.socialNetwork.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import proj.socialNetwork.Subscription;
import java.util.*;

public class SubscriptionJdbcDAO  {

    static RowMapper<Subscription> rowMapper = (rs, rowNum) ->
            new Subscription(
            (UUID) rs.getObject("subscriber_uuid"),
            (UUID) rs.getObject("publisher_uuid"),
            rs.getTimestamp("subscription_date").toInstant());

    public static void create(Subscription subscription, JdbcTemplate jdbcTemplate) {
        var sql = "INSERT INTO subscription (subscriber_uuid, publisher_uuid, subscription_date) VALUES (?, ?, ?)";
        var create = jdbcTemplate.update(
                sql,
                subscription.getSubscriberUuid(),
                subscription.getPublisherUuid(),
                subscription.getSubscriptionDate());
        if (create == 1)
            System.out.println("New subscription was made");
    }

    public static void delete(UUID subscriberUuid, UUID publisherUuid, JdbcTemplate jdbcTemplate) {
        var sql = "DELETE FROM subscription WHERE subscriber_uuid = ? AND publisher_uuid = ? ";
        jdbcTemplate.update(sql, subscriberUuid, publisherUuid);
    }

}
