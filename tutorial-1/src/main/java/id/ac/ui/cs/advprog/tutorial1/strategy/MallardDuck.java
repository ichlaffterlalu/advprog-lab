package id.ac.ui.cs.advprog.tutorial1.strategy;

public class MallardDuck extends Duck {
    // TODO Complete me!
    public MallardDuck() {
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
