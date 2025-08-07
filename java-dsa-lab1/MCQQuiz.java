import java.util.Scanner;

public class MCQQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Question
        System.out.println("What is the capital of Pakistan?");
        
        // Answer choices
        System.out.println("A) Karachi");
        System.out.println("B) Islamabad");
        System.out.println("C) Lahore");
        
        // Get user input
        System.out.print("Enter your answer (A, B, or C): ");
        String answer = sc.nextLine().toUpperCase();
        
        // Check answer and display result
        if (answer.equals("B")) {
            System.out.println("Correct! Islamabad is the capital of Pakistan.");
        } else {
            System.out.println("Wrong! The correct answer is B) Islamabad.");
        }
        
        sc.close();
    }
}