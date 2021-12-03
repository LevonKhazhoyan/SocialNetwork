package proj.socialNetwork.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(
        name="subscription",
        uniqueConstraints=
        @UniqueConstraint(name = "subscription_constraint", columnNames = {"subscriber_uuid", "publisher_uuid"})
)
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "subscriber_uuid",
            nullable = false
    )
    private UUID subscriberUUID;
    @Column(
            name = "publisher_uuid",
            nullable = false
    )
    private UUID publisherUuid;
    @Column(
            name = "subscription_date",
            nullable = false
    )
    private Instant subscriptionDate;

    public Subscription() {}

    public Subscription(Long id,UUID subscriberUuid, UUID publisherUuid, Instant subscriptionDate) {
        this.subscriberUUID = Objects.requireNonNull(subscriberUuid);
        this.publisherUuid = Objects.requireNonNull(publisherUuid);
        this.subscriptionDate = Objects.requireNonNull(subscriptionDate);
        this.id = Objects.requireNonNull(id);
    }

    public Subscription(UUID subscriberUuid, UUID publisherUuid) {
        this(new Random().nextLong(),subscriberUuid, publisherUuid, Instant.now());
    }

    public Long getId() {
        return id;
    }

    public UUID getSubscriberUUID() {
        return subscriberUUID;
    }

    public UUID getPublisherUuid() {
        return publisherUuid;
    }

    public Instant getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubscriberUUID(UUID subscriberUUID) {
        this.subscriberUUID = subscriberUUID;
    }

    public void setPublisherUuid(UUID publisherUuid) {
        this.publisherUuid = publisherUuid;
    }

    public void setSubscriptionDate(Instant subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public static String toString(Subscription sub) {
        return "Subscription{" +
                "subscriberUuid=" + sub.getSubscriberUUID().toString() +
                ", publisherUuid=" + sub.getPublisherUuid().toString() +
                ", subscriptionDate=" + sub.getSubscriptionDate().toString() + '}';
    }

}