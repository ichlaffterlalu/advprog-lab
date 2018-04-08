package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class Cheese extends Food {
    Food food;

    public Cheese(Food food) {
        //TODO Implement
        this.food = food;
    }

    @Override
    public String getDescription() {
        //TODO Implement
        return food.getDescription() + ", adding cheese";
    }

    @Override
    public double cost() {
        //TODO Implement
        return food.cost() + 2.00;
    }
}
