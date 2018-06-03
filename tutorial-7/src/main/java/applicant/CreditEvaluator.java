package applicant;

import java.util.function.Predicate;

public class CreditEvaluator implements Evaluator {
    public Predicate<Applicant> getEvaluator() {
        return apc -> apc.getCreditScore() > 600;
    }
}