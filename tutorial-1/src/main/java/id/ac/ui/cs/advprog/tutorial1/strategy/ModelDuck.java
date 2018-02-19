package id.ac.ui.cs.advprog.tutorial1.strategy;

public class ModelDuck extends Duck {
    // TODO Complete me!
    public ModelDuck() {
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyNoWay();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}
