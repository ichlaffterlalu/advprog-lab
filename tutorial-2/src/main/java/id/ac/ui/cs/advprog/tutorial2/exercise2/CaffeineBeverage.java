package id.ac.ui.cs.advprog.tutorial2.exercise2;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        // TODO Complete me!
        this.boilWater();
        this.brew();
        this.pourInCup();
        this.addCondiments();
    }

    protected abstract void addCondiments();

    protected abstract void brew();

    public void boilWater() {
        System.out.println("Boiling water");
    }

    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
