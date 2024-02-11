import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    String[] options;
    int correctOptionIndex;

    public QuizQuestion(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
}

public class Quiz {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static Timer timer = new Timer();

    private static QuizQuestion[] questions = {
        new QuizQuestion("What is the capital of France?", new String[]{"A. Paris", "B. London", "C. Rome", "D. Berlin"}, 0),
        new QuizQuestion("What is the largest planet in our solar system?", new String[]{"A. Jupiter", "B. Saturn", "C. Earth", "D. Mars"}, 0),
        new QuizQuestion("Who wrote 'Romeo and Juliet'?", new String[]{"A. William Shakespeare", "B. Charles Dickens", "C. Jane Austen", "D. Mark Twain"}, 0),
    };

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        score = 0;
        currentQuestionIndex = 0;

        System.out.println("Welcome to the Quiz!");

        for (QuizQuestion question : questions) {
            displayQuestion(question);
            waitForAnswer(question);
        }

        System.out.println("Quiz Ended!");
        System.out.println("Your Score: " + score + "/" + questions.length);
        scanner.close();
    }

    private static void displayQuestion(QuizQuestion question) {
        System.out.println(question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
    }

    private static void waitForAnswer(QuizQuestion question) {
        System.out.print("Enter your answer (A/B/C/D): ");

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                displayCorrectAnswer(question);
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    QuizQuestion nextQuestion = questions[currentQuestionIndex];
                    displayQuestion(nextQuestion);
                    waitForAnswer(nextQuestion);
                }
            }
        };

        timer.schedule(task, 10000); // 10 seconds timer

        String userAnswer = scanner.nextLine().toUpperCase();
        timer.cancel(); // Cancel the timer since the user has provided an answer

        if (userAnswer.equals(question.options[question.correctOptionIndex].substring(0, 1))) {
            System.out.println("Correct answer!");
            score++;
        } else {
            System.out.println("Incorrect answer!");
            displayCorrectAnswer(question);
        }
    }

    private static void displayCorrectAnswer(QuizQuestion question) {
        System.out.println("Correct answer is: " + question.options[question.correctOptionIndex]);
    }
}


