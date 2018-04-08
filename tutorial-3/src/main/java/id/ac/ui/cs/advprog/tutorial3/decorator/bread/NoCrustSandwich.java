package id.ac.ui.cs.advprog.tutorial3.decorator.bread;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class NoCrustSandwich extends Food {
    public NoCrustSandwich() {
        //TODO Implement
        description = "No Crust Sandwich";
    }

    @Override
    public double cost() {
        //TODO Implement
        return 2.00;
    }
}
