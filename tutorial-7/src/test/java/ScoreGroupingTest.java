import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class ScoreGroupingTest {
    // TODO Implement me!
    // Increase code coverage in ScoreGrouping class
    // by creating unit test(s)!
    private static final Map<String, Integer> SCORES = new HashMap<>();

    @BeforeClass
    public static void setUp() {
        SCORES.put("Areng",10);
        SCORES.put("Rey",15);
        SCORES.put("Adri",15);
        SCORES.put("Agas",11);
        SCORES.put("Ayaz",15);
        SCORES.put("Ridwan",10);
        SCORES.put("Naomi",-5);
    }

    @Test
    public void testScoreGroupingIsCorrect() {
        Map<Integer, List<String>> result = ScoreGrouping.groupByScores(SCORES);
        result.forEach((key, value) -> value.forEach(v -> assertTrue(SCORES.get(v) == key)));
    }
}