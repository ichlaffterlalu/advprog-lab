package game;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by billy on 9/27/16.
 * Edited by hafiyyan94 on 4/10/18
 */

public class Main {

    private static final int TOTAL_QUEST = 10;
    private static final int RIGHT_BELOW_THRESHOLD_POINT = 10;
    private static final int RIGHT_ABOVE_THRESHOLD_POINT = 5;
    private static final int WRONG_POINT = 0;
    private static final int QUEST_TYPE_ADD = 0;
    private static final int QUEST_TYPE_SUBSTR = 1;
    private static final int QUEST_TYPE_MULTIPL = 2;
    private static final int QUEST_TYPE_DIVS = 3;

    public static void main(String[] args) {
        // initialize game components
        Scanner scanner = new Scanner(System.in);
        PointCounter score = new PointCounter();
        Timer gameTimer = new Timer();
        gameTimer.addObserver(score);

        // initialize game variables
        String startNewQuestsIpt;
        int thresholdTime;
        int totalRightBelowThreshold;
        int totalRightAboveThreshold;
        int totalWrong;
        double totalTime;

        do {
            // initialize value
            startNewQuestsIpt = "";
            totalRightBelowThreshold = 0;
            totalRightAboveThreshold = 0;
            totalWrong = 0;
            totalTime = 0;
            gameTimer.reset();
            score.resetScore();

            // Asking for asnwering question threshold time
            System.out.print("How much time do you need "
                    + "to answer each question? (In second) ");
            String rawInput = scanner.nextLine();
            thresholdTime = rawInput.isEmpty() ? 20 : Integer.parseInt(rawInput);


            for (int questNo = 1; questNo <= TOTAL_QUEST; questNo++) {
                gameTimer.reset();
                gameTimer.start();

                System.out.print(questNo + ") ");
                Random rand = new Random();
                Fraction firstPosFrac = new Fraction(rand.nextInt(40) - 20,
                        rand.nextInt(40) - 20);
                Fraction secondPosFrac = new Fraction(rand.nextInt(40) - 20,
                        rand.nextInt(40) - 20);
                Fraction expectedAnswer;

                switch (rand.nextInt(3)) {
                    case QUEST_TYPE_ADD:
                        System.out.print(firstPosFrac.toString() + "  +  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getAddition(secondPosFrac);
                        break;
                    case QUEST_TYPE_SUBSTR:
                        System.out.print(firstPosFrac.toString() + "  -  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getSubstraction(secondPosFrac);
                        break;
                    case QUEST_TYPE_MULTIPL:
                        System.out.print(firstPosFrac.toString() + "  *  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getMultiplication(secondPosFrac);
                        break;
                    case QUEST_TYPE_DIVS:
                        System.out.print(firstPosFrac.toString() + "  :  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getDivision(secondPosFrac);
                        break;
                    default:
                        System.out.println("Oooops!");
                        expectedAnswer = new Fraction();
                }

                // Asking for question
                // And capture before and after the time in milis
                gameTimer.start();
                String rawAns = scanner.nextLine();
                gameTimer.stop();

                // Process user answer
                Fraction userAnswer;
                if (rawAns.contains("/")) {
                    String[] ans = rawAns.split("/");
                    userAnswer = new Fraction(Integer.parseInt(ans[0]),
                            Integer.parseInt(ans[1]));
                } else {
                    userAnswer = new Fraction(Integer.parseInt(rawAns));
                }

                // Check answer
                if (expectedAnswer.isEqual(userAnswer)) {
                    if (gameTimer.getCurrentTime() / 1000 <= thresholdTime) {
                        score.correctOnTime();
                        totalRightBelowThreshold++;
                    } else {
                        score.correctLate();
                        totalRightAboveThreshold++;
                    }
                } else {
                    totalWrong++;
                }

                // Print current round result
                double currentTime = ((double) gameTimer.getCurrentTime()) / 1000;
                System.out.println("Current score: " + score.getScore() + "Time needed: "
                        + currentTime + "\n");
                totalTime += currentTime;
            }
            // Print the result
            System.out.println("\n=========Result==========");
            System.out.println("Right answer and within time limit  =  "
                    + totalRightBelowThreshold);
            System.out.println("Right answer but over time limit  =  "
                    + totalRightAboveThreshold);
            System.out.println("Wrong answer  =  " + totalWrong);
            System.out.println("\nTotal points acquired : " + score.getScore());
            System.out.println("\nTotal time needed : " + totalTime);
            System.out.println("\n");

            // Asking if user want to start a new questions
            // if the respond is not what we want, ask it again and again
            while (!startNewQuestsIpt.equalsIgnoreCase("y")
                    && !startNewQuestsIpt.equalsIgnoreCase("n")) {
                System.out.println("Restart the quiz? [y/n]");
                startNewQuestsIpt = scanner.nextLine();
            }
            System.out.println("\n\n\n\n\n\n");
        } while (startNewQuestsIpt.equalsIgnoreCase("y"));
        // while user input yes, do same step again
    }
}
