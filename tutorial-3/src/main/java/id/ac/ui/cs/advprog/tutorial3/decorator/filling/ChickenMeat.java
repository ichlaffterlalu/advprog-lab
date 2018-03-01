package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class ChickenMeat extends Food {
    Food food;

    public ChickenMeat(Food food) {
        //TODO Implement
        this.food = food;
    }

    @Override
    public String getDescription() {
        //TODO Implement
        return food.getDescription() + ", adding chicken meat";
    }

    @Override
    public double cost() {
        //TODO Implement
        return food.cost() + 4.50;
    }
}
