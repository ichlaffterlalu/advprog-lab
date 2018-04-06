package applicant;

import java.util.function.Predicate;

public class CriminalRecordsEvaluator implements Evaluator {
    public Predicate<Applicant> getEvaluator() {
        return apc -> !apc.hasCriminalRecord();
    }
}
