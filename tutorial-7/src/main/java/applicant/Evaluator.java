package applicant;

import java.util.function.Predicate;

public interface Evaluator {
    Predicate<Applicant> getEvaluator();
}
