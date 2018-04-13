package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DoughTest {

    private Dough dough;

    @Test
    public void testDoughClassesHasToStringOverride() {
        dough = new NoCrustDough();
        assertNotNull(dough.toString());
        dough = new ThickCrustDough();
        assertNotNull(dough.toString());
        dough = new ThinCrustDough();
        assertNotNull(dough.toString());
    }
}