package tutorial.javari;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

import tutorial.javari.animal.Animal;
import tutorial.javari.animal.Condition;
import tutorial.javari.animal.Gender;

public class DatabaseManager {

    private static final String CSV_PATH = "javari_data.csv";
    private static final Path FILE = Paths.get("", CSV_PATH);
    private List<Animal> animals;

    public DatabaseManager() throws IOException {
        this.animals = new ArrayList<Animal>();
        loadData();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Animal getAnimalById(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public Animal addAnimal(String json) throws IOException {
        Animal newAnimal = jsonToAnimal(json);
        if (!duplicateId(newAnimal)) {
            animals.add(newAnimal);
            saveData();
            return newAnimal;
        }
        return null;
    }

    public Animal deleteAnimalById(int id) throws IOException {
        Animal animal = null;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == id) {
                animal = animals.remove(i);
                saveData();
                break;
            }
        }
        return animal;
    }

    private void loadData() throws IOException {
        Files.lines(FILE).forEach(line -> animals.add(csvToAnimal(line)));
    }

    private void saveData() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        animals.forEach(animal -> lines.add(animalToCsv(animal)));
        Files.write(FILE, lines, Charset.defaultCharset(), StandardOpenOption.WRITE);
    }

    private boolean duplicateId(Animal subject) {
        return animals.stream().anyMatch(animal -> animal.getId() == subject.getId());
    }

    private Animal csvToAnimal(String line) {
        String[] attrs = line.split(",");
        return new Animal(Integer.parseInt(attrs[0]),
                attrs[1], attrs[2], Gender.parseGender(attrs[3]),
                Double.parseDouble(attrs[4]), Double.parseDouble(attrs[5]),
                Condition.parseCondition(attrs[6]));
    }

    private String animalToCsv(Animal animal) {
        String[] attrs = {animal.getId().toString(), animal.getType(),
                animal.getName(), animal.getGender().toString(), String.valueOf(animal.getLength()),
                String.valueOf(animal.getWeight()), animal.getCondition().toString()};
        return String.join(",", attrs);
    }

    private Animal jsonToAnimal(String input) {
        JSONObject json = new JSONObject(input);
        return new Animal(json.getInt("id"), json.getString("type"),
                json.getString("name"), Gender.parseGender(json.getString("gender")),
                json.getDouble("length"), json.getDouble("weight"),
                Condition.parseCondition(json.getString("condition")));

    }
}
