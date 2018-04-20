package tutorial.javari.animal;

/**
 * This class describes possible health conditions for an animal.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author Ichlasul Affan
 *     Changed the value of SICK_STR to "sick" to increase consistency.
 */
public enum Condition {

    HEALTHY, SICK;
    private static final String HEALTHY_STR = "healthy";
    private static final String SICK_STR = "sick";

    /**
     * Returns the correct condition enum based on given string representation
     * of a condition.
     *
     * @param str   condition description
     * @return
     */
    public static Condition parseCondition(String str) {
        if (str.equalsIgnoreCase(HEALTHY_STR)) {
            return Condition.HEALTHY;
        } else if (str.equalsIgnoreCase(SICK_STR)) {
            return Condition.SICK;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
