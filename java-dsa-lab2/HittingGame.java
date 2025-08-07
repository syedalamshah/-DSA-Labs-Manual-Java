import java.util.Random;

public class HittingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        
        // Generate random number of players (1-10)
        int totalPlayers = rand.nextInt(10) + 1;
        System.out.println("Your team has " + totalPlayers + " players");
        System.out.println("Game Started!\n");
        
        int yourHits = 0;
        int enemyHits = 0;
        
        // Play rounds equal to number of players
        for (int i = 1; i <= totalPlayers; i++) {
            // Generate pair of random numbers (1-6)
            int num1 = rand.nextInt(6) + 1;
            int num2 = rand.nextInt(6) + 1;
            
            System.out.print("Round " + i + ": [" + num1 + ", " + num2 + "] - ");
            
            if (num1 == num2) {
                System.out.println("Enemy got hit by your team!");
                yourHits++;
            } else {
                System.out.println("You got hit by the enemy team!");
                enemyHits++;
            }
        }
        
        // Display final result
        System.out.println("\n=== GAME RESULTS ===");
        System.out.println("Your hits: " + yourHits);
        System.out.println("Enemy hits: " + enemyHits);
        
        if (yourHits > enemyHits) {
            System.out.println("🎉 YOUR TEAM WINS! 🎉");
        } else if (enemyHits > yourHits) {
            System.out.println("😞 ENEMY TEAM WINS! 😞");
        } else {
            System.out.println("🤝 IT'S A TIE! 🤝");
        }
    }
}