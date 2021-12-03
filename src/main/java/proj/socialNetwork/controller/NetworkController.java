package proj.socialNetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proj.socialNetwork.entities.Person;
import proj.socialNetwork.entities.Subscription;
import proj.socialNetwork.service.NetworkService;
import java.util.List;
import java.util.UUID;

@RestController
public class NetworkController {

    @Autowired
    private final NetworkService networkService;

    public NetworkController(NetworkService networkService) {
        this.networkService = networkService;
    }

    @PostMapping(value = "/addPerson")
    public Person addPerson(@RequestBody Person person) {
        return networkService.savePerson(person);
    }

    @PostMapping(value = "/addSubscription")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return networkService.saveSubscription(subscription);
    }

    @PostMapping("/addPersons")
    public List<Person> addPersons(@RequestBody List<Person> person) {
        return networkService.savePersons(person);
    }

    @PostMapping("/addSubscriptions")
    public List<Subscription> addSubscriptions(@RequestBody List<Subscription> subscriptions) {
        return networkService.saveSubscriptions(subscriptions);
    }

    @PutMapping("/updatePerson")
    public Person updatePerson(@RequestBody Person person) {
        return networkService.updatePerson(person);
    }

    @PutMapping("/updateSubscription")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return networkService.updateSubscription(subscription);
    }

    @GetMapping("/persons")
    public List<Person> findPersons() {
        return networkService.getPersons();
    }

    @GetMapping("/subscriptions")
    public List<Subscription> findSubscriptions() {
        return networkService.getSubscriptions();
    }

    @GetMapping("/person/{uuid}")
    public Person findPersonByUUID(@PathVariable UUID uuid) {
        return networkService.getPersonByUUID(uuid);
    }

    @GetMapping("/subscription/{id}")
    public List<Subscription> findSubscriptionByUUID(@PathVariable Long id) {
        return networkService.getSubscriptionByID(id);
    }

    @GetMapping("/person/{login}")
    public Person findPersonByLogin(@PathVariable String login) {
        return networkService.getPersonByLogin(login);
    }

    @DeleteMapping("/deletePerson/{uuid}")
    public String deletePerson(@PathVariable String uuid) {
        return networkService.deletePerson(UUID.fromString(uuid));
    }

    @DeleteMapping("/deleteSub/{uuid}")
    public String deleteSubscription(@PathVariable Long id) {
        return networkService.deleteSubscription(id);
    }

}