package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CheeseTest {

    private Cheese cheese;

    @Test
    public void testCheeseClassesHasToStringOverride() {
        cheese = new KraftCheese();
        assertNotNull(cheese.toString());
        cheese = new MozzarellaCheese();
        assertNotNull(cheese.toString());
        cheese = new ParmesanCheese();
        assertNotNull(cheese.toString());
        cheese = new ReggianoCheese();
        assertNotNull(cheese.toString());
    }
}