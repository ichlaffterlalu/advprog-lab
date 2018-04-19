package tutorial.javari;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorial.javari.animal.Animal;

@RestController
public class JavariController {
    DatabaseManager database = new DatabaseManager();

    public JavariController() throws IOException {
    }

    @GetMapping("/javari")
    public Object getAnimals() {
        List<Animal> animals = database.getAnimals();
        if (animals == null || animals.isEmpty()) {
            return JsonMessage.getDatabaseEmptyMessage();
        }
        return animals;
    }

    @GetMapping("/javari/{id}")
    public Object getAnimalById(@PathVariable Integer id) {
        Animal animal = database.getAnimalById(id);
        if (animal == null) {
            return JsonMessage.getNotFoundMessage(id);
        }
        return animal;
    }

    @DeleteMapping("/javari/{id}")
    public Object deleteAnimalById(@PathVariable Integer id) throws IOException {
        Animal animal = database.deleteAnimalById(id);
        if (animal == null) {
            return JsonMessage.getNotFoundMessage(id);
        }

        Object[] jsonArr = {JsonMessage.getSuccessDeleteMessage(), animal};
        return jsonArr;
    }

    @PostMapping("/javari")
    public Object createAnimal(@RequestBody String json) throws IOException {
        Animal animal = database.addAnimal(json);
        Object[] jsonArr = {JsonMessage.getSuccessAddMessage(), animal};

        return jsonArr;
    }
}