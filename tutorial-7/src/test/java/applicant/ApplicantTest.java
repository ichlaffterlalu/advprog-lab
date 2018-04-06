package applicant;

import static applicant.Applicant.evaluate;
import static applicant.Applicant.main;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

public class ApplicantTest {
    // TODO Implement me!
    // Increase code coverage in Applicant class
    // by creating unit test(s)!

    Applicant applicant = new Applicant();

    Predicate<Applicant> qualifiedEvaluator = new QualifiedEvaluator().getEvaluator();
    Predicate<Applicant> creditEvaluator = new CreditEvaluator().getEvaluator();
    Predicate<Applicant> criminalEvaluator = new CriminalRecordsEvaluator().getEvaluator();
    Predicate<Applicant> employmentEvaluator = new EmploymentEvaluator().getEvaluator();

    public boolean mainChecker() {
        main(null);
        return true;
    }

    @Test
    public void checkQualifiedEvaluator() {
        assertTrue(evaluate(applicant, qualifiedEvaluator));
    }

    @Test
    public void checkCreditEvaluator() {
        assertTrue(evaluate(applicant, creditEvaluator));
    }

    @Test
    public void checkCriminalEvaluator() {
        assertFalse(evaluate(applicant, criminalEvaluator));
    }

    @Test
    public void checkEmploymentEvaluator() {
        assertTrue(evaluate(applicant, employmentEvaluator));
    }

    @Test
    public void checkChainedEvaluator() {
        assertFalse(evaluate(applicant, qualifiedEvaluator.and(criminalEvaluator)));
    }

    @Test
    public void checkMainMethodIsRunning() {
        assertTrue(mainChecker());
    }
}