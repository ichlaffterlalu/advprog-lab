package id.ac.ui.cs.advprog.tutorial4.exercise2;

public class Singleton {

    // TODO Implement me!
    // What's missing in this Singleton declaration?
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        // TODO Implement me!
        return INSTANCE;
    }
}
