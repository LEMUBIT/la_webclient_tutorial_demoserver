package lemubit.academy.la_webclient_tutorial_demoserver;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyRestController {

    Person person = new Person();

    @GetMapping("/person/{id}")
    public Person getPerson_Server(@PathVariable int id) {
        simulateDelayedProcessing();
        return person.getPerson(id);
    }


    @GetMapping("/people")
    public List<Person> getPeople_Server() {
        simulateDelayedProcessing();
        return person.getAllPeople();
    }

    @PostMapping("/person")
    public Person addPerson_Server(@RequestBody Person p1){
        simulateDelayedProcessing();
        return person.addPerson(p1);
    }

    //Just to simulate a delay
    void simulateDelayedProcessing() {
        try {
            Thread.sleep(5000); //5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
