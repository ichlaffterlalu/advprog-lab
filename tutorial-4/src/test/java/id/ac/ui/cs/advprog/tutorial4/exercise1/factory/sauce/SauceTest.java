package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SauceTest {

    private Sauce sauce;

    @Test
    public void testDoughClassesHasToStringOverride() {
        sauce = new IndomieSeasoningSauce();
        assertNotNull(sauce.toString());
        sauce = new MarinaraSauce();
        assertNotNull(sauce.toString());
        sauce = new PlumTomatoSauce();
        assertNotNull(sauce.toString());
    }
}