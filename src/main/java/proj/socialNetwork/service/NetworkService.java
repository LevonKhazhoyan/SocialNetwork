package proj.socialNetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.socialNetwork.entities.Person;
import proj.socialNetwork.repository.PersonRepository;
import proj.socialNetwork.entities.Subscription;
import proj.socialNetwork.repository.SubscriptionRepository;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class NetworkService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Person> getPersons() {
        System.out.println("List of persons is presented");
        return personRepository.findAll();
    }
    public List<Subscription> getSubscriptions() {
        System.out.println("List of subscriptions is presented");
        return subscriptionRepository.findAll();
    }

    public Person savePerson(Person person) {
        System.out.println("Person " + person.getLogin() + " is registered");
        return personRepository.save(person);
    }

    public List<Person> savePersons(List<Person> persons) {
        System.out.println("List of persons is registered");
        return personRepository.saveAll(persons);
    }

    public Subscription saveSubscription(Subscription subscription) {
        System.out.println("Subscription by " +
                subscription.getSubscriberUUID() + " on " + subscription.getPublisherUuid() + " is done");
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> saveSubscriptions(List<Subscription> subscription) {
        System.out.println("List of subscriptions is done");
        return subscriptionRepository.saveAll(subscription);
    }

    public Person getPersonByUUID(UUID uuid) {
        System.out.println("Person:" + uuid + "is presented");
        return personRepository.findById(uuid).orElse(null);
    }

    public Person getPersonByLogin(String login) {
        System.out.println("Person: " + login + " is presented");
        return personRepository.findByLogin(login);
    }

    public List<Subscription> getSubscriptionByID(Long id) {
        System.out.println("Subscription with " + id + " is presented");
        return subscriptionRepository.findAllById(Collections.singleton(id));
    }

    public Person updatePerson(Person person) {
        Person existingPerson = personRepository.findById(person.getUuid()).orElse(null);
        assert existingPerson != null;
        existingPerson.setLogin(person.getLogin());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setDob(person.getDob());
        existingPerson.setGender(person.getGender());
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        System.out.println("Person " + person.getLogin() + " is updated" );
        return personRepository.save(existingPerson);
    }

    public Subscription updateSubscription(Subscription subscription) {
        Subscription existingSubscription = subscriptionRepository.findById(subscription.getId()).orElse(null);
        assert existingSubscription != null;
        existingSubscription.setSubscriberUUID(subscription.getSubscriberUUID());
        existingSubscription.setPublisherUuid(subscription.getPublisherUuid());
        existingSubscription.setSubscriptionDate(subscription.getSubscriptionDate());
        System.out.println("Subscription " + subscription.getId() + " is presented");
        return subscriptionRepository.save(existingSubscription);
    }

    public String deletePerson(UUID uuid) {
        personRepository.deleteById(uuid);
        System.out.println("Person " + uuid + " is removed");
        return "Person " + uuid + " is removed";
    }

    public String deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
        System.out.println("Person " + id + " is removed");
        return "Person " + id + " is removed";
    }

}