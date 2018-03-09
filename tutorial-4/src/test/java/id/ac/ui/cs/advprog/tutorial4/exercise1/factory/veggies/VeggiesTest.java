package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class VeggiesTest {

    private Veggies veggies;

    @Test
    public void testDoughClassesHasToStringOverride() {
        veggies = new BlackOlives();
        assertNotNull(veggies.toString());
        veggies = new Capcay();
        assertNotNull(veggies.toString());
        veggies = new Eggplant();
        assertNotNull(veggies.toString());
        veggies = new Garlic();
        assertNotNull(veggies.toString());
        veggies = new Mushroom();
        assertNotNull(veggies.toString());
        veggies = new Onion();
        assertNotNull(veggies.toString());
        veggies = new RedPepper();
        assertNotNull(veggies.toString());
        veggies = new Spinach();
        assertNotNull(veggies.toString());
    }
}