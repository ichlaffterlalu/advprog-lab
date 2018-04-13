package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ClamTest {

    private Clams clam;

    @Test
    public void testClamClassesHasToStringOverride() {
        clam = new FreshClams();
        assertNotNull(clam.toString());
        clam = new FrozenClams();
        assertNotNull(clam.toString());
        clam = new HavenWhiteClams();
        assertNotNull(clam.toString());
    }
}