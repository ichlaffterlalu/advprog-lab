package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class Lettuce extends Food {
    Food food;

    public Lettuce(Food food) {
        //TODO Implement
        this.food = food;
    }

    @Override
    public String getDescription() {
        //TODO Implement
        return food.getDescription() + ", adding lettuce";
    }

    @Override
    public double cost() {
        //TODO Implement
        return food.cost() + 0.75;
    }
}
