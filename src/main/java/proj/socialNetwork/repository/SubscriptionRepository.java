package proj.socialNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.socialNetwork.entities.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}