package applicant;

import java.util.function.Predicate;

public class EmploymentEvaluator implements Evaluator {
    public Predicate<Applicant> getEvaluator() {
        return apc -> apc.getEmploymentYears() > 0;
    }
}
