package id.ac.ui.cs.advprog.tutorial4.exercise1;

import static org.junit.Assert.assertEquals;

import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.Pizza;
import org.junit.Test;

public class PizzaStoreTest {

    private PizzaStore pizzaStore;

    @Test
    public void testOrderNewYorkCheesePizza() {
        pizzaStore = new NewYorkPizzaStore();
        Pizza cheesePizza = pizzaStore.orderPizza("cheese");
        assertEquals("New York Style Cheese Pizza", cheesePizza.getName());
    }

    @Test
    public void testOrderNewYorkClamPizza() {
        pizzaStore = new NewYorkPizzaStore();
        Pizza clamPizza = pizzaStore.orderPizza("clam");
        assertEquals("New York Style Clam Pizza", clamPizza.getName());
    }

    @Test
    public void testOrderNewYorkVeggiePizza() {
        pizzaStore = new NewYorkPizzaStore();
        Pizza veggiePizza = pizzaStore.orderPizza("veggie");
        assertEquals("New York Style Veggie Pizza", veggiePizza.getName());
    }

    @Test
    public void testOrderDepokCheesePizza() {
        pizzaStore = new DepokPizzaStore();
        Pizza cheesePizza = pizzaStore.orderPizza("cheese");
        assertEquals("Depok Style Cheese Pizza", cheesePizza.getName());
    }

    @Test
    public void testOrderDepokClamPizza() {
        pizzaStore = new DepokPizzaStore();
        Pizza clamPizza = pizzaStore.orderPizza("clam");
        assertEquals("Depok Style Clam Pizza", clamPizza.getName());
    }

    @Test
    public void testOrderDepokVeggiePizza() {
        pizzaStore = new DepokPizzaStore();
        Pizza veggiePizza = pizzaStore.orderPizza("veggie");
        assertEquals("Depok Style Veggie Pizza", veggiePizza.getName());
    }

    @Test
    public void testPizzaTestDriveHasMainMethod() {
        PizzaTestDrive.main(new String[0]);
    }
}