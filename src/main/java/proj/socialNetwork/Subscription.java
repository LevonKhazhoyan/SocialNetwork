package proj.socialNetwork;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Subscription {

    private final UUID subscriberUuid;
    private final UUID publisherUuid;
    private final Instant subscriptionDate;

    public Subscription(UUID subscriberUuid, UUID publisherUuid, Instant subscriptionDate) {
        this.subscriberUuid = Objects.requireNonNull(subscriberUuid);
        this.publisherUuid = Objects.requireNonNull(publisherUuid);
        this.subscriptionDate = Objects.requireNonNull(subscriptionDate);
    }

    public Subscription(UUID subscriberUuid, UUID publisherUuid){
        this(subscriberUuid, publisherUuid, Instant.now());
    }

    public UUID getSubscriberUuid() {
        return subscriberUuid;
    }

    public UUID getPublisherUuid() {
        return publisherUuid;
    }

    public Instant getSubscriptionDate() {
        return subscriptionDate;
    }

    public static String toString(Subscription sub) {
        return "Subscription{" +
                "subscriberUuid=" + sub.getSubscriberUuid().toString() +
                ", publisherUuid=" + sub.getPublisherUuid().toString() +
                ", subscriptionDate=" + sub.getSubscriptionDate().toString() + '}';
    }
}
