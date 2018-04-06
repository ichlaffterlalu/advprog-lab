package applicant;

import java.util.function.Predicate;

public class QualifiedEvaluator implements Evaluator {
    public Predicate<Applicant> getEvaluator() {
        return apc -> apc.getEmploymentYears() > 0;
    }
}
