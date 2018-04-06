package applicant;

import java.util.function.Predicate;

/**
 * 4th exercise.
 */
public class Applicant {

    public int getCreditScore() {
        return 700;
    }

    public int getEmploymentYears() {
        return 10;
    }

    public boolean hasCriminalRecord() {
        return true;
    }

    public static boolean evaluate(Applicant applicant, Predicate<Applicant> evaluator) {
        return evaluator.test(applicant);
    }

    private static void printEvaluation(boolean result) {
        String msg = "Result of evaluating applicant: %s";
        msg = result ? String.format(msg, "accepted") : String.format(msg, "rejected");

        System.out.println(msg);
    }

    public static void main(String[] args) {
        Applicant applicant = new Applicant();

        Predicate<Applicant> qualifiedEvaluator = new QualifiedEvaluator().getEvaluator();
        Predicate<Applicant> creditEvaluator = new CreditEvaluator().getEvaluator();
        Predicate<Applicant> criminalEvaluator = new CriminalRecordsEvaluator().getEvaluator();
        Predicate<Applicant> employmentEvaluator = new EmploymentEvaluator().getEvaluator();

        printEvaluation(evaluate(applicant,
                qualifiedEvaluator.and(creditEvaluator)));
        printEvaluation(evaluate(applicant,
                qualifiedEvaluator.and(employmentEvaluator)
                        .and(creditEvaluator)));
        printEvaluation(evaluate(applicant,
                qualifiedEvaluator.and(employmentEvaluator)
                        .and(criminalEvaluator)));
        printEvaluation(evaluate(applicant,
                qualifiedEvaluator.and(employmentEvaluator)
                        .and(creditEvaluator)
                        .and(criminalEvaluator)));

    }
}