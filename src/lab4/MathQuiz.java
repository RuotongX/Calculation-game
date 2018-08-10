package lab4;

import java.util.Random;
import java.util.Scanner;

public class MathQuiz {

    public static void main(String[] args) {
        int score = 0;
        int rounds = 10;

        MathQuiz quiz = new MathQuiz();

        Scanner scanner = new Scanner(System.in);
        String userInput;
        //terminate is used to check if it needs to terminate the program (user inputs x)
        boolean terminate = false;
        for (int round = 0; round < rounds; ++round) {
            System.out.println("Round " + (round + 1));
            //print the question and get the correct answer
            double correctAnswer = quiz.generateQuestion();
            double uAnswer = 0d;
            //valid is used to check if the user input is valid
            boolean valid = false;
            do {
                //get the user input from command line
                userInput = scanner.nextLine();
                if (userInput.trim().equals("x")) {
                    terminate = true;
                    break;
                }
                try {
                    uAnswer = Double.parseDouble(userInput.trim());
                    valid = true;
                } catch (NumberFormatException e) {
                    //the exception is caught is the user input is not valid
                    valid = false;
                    System.out.println("The input is invalid, please enter the answer again.");
                }
            } while (!valid);
            if (terminate) {
                break;
            }
            if (quiz.checkAnswer(uAnswer, correctAnswer) == 1) {
                System.out.println("Answer correct!");
                score += 10;
            } else {
                System.out.println("Sorry, you are wrong.");
                score -= 10;
            }
        }

        System.out.println("You got: " + score);

    }

    /**
     * Generate and print the question.
     *
     * @return the correct answer of the question.
     */
    public double generateQuestion() {
        double correctResult = 0;
        int operator = generateNumber(4);
        String opStr = "";
        int num1 = generateNumber(100);
        int num2 = generateNumber(100);

        switch (operator) {
            case 0:
                correctResult = num1 + num2;
                opStr = " + ";
                break;
            case 1:
                correctResult = num1 - num2;
                opStr = " - ";
                break;
            case 2:
                correctResult = num1 * num2;
                opStr = " * ";
                break;
            default:
                while (num2 == 0) {
                    num2 = generateNumber(100);
                }
                correctResult = 1.0 * num1 / num2;
                opStr = " / ";
                break;
        }

        System.out.println(num1 + opStr + num2 + " = ");

        return correctResult;
    }

    /**
     * Generate a random number - reuse
     *
     * @return
     */
    public int generateNumber(int range) {
        Random generator = new Random();
        int i = generator.nextInt(range);
        return i;
    }

    /**
     * Check the correctness of your answer. If the answer is correct, it
     * returns 1, otherwise return 0.
     *
     * @param uAnswer
     * @param cAnswer
     * @return
     */
    public int checkAnswer(double uAnswer, double cAnswer) {
        //if the difference of your answer and correct answer is <= the threashhold,
        //the answer is correct
        //Math.abs(num) returns the absolute value of the num
        if (Math.abs(uAnswer - cAnswer) <= 0.1) {
            return 1;
        }
        return 0;

    }

}
