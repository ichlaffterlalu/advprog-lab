package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class BeefMeat extends Food {
    Food food;

    public BeefMeat(Food food) {
        //TODO Implement
        this.food = food;
    }

    @Override
    public String getDescription() {
        //TODO Implement
        return food.getDescription() + ", adding beef meat";
    }

    @Override
    public double cost() {
        //TODO Implement
        return food.cost() + 6.00;
    }
}
