package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class ChiliSauce extends Food {
    Food food;

    public ChiliSauce(Food food) {
        //TODO Implement
        this.food = food;
    }

    @Override
    public String getDescription() {
        //TODO Implement
        return food.getDescription() + ", adding chili sauce";
    }

    @Override
    public double cost() {
        //TODO Implement
        return food.cost() + 0.30;
    }
}
