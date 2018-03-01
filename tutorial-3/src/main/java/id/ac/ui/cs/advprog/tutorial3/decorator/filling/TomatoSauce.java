package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class TomatoSauce extends Food {
    Food food;

    public TomatoSauce(Food food) {
        //TODO Implement
        this.food = food;
    }

    @Override
    public String getDescription() {
        //TODO Implement
        return food.getDescription() + ", adding tomato sauce";
    }

    @Override
    public double cost() {
        //TODO Implement
    }
}
