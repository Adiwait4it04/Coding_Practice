import java.util.*;

public class PassTheBall {
    
    static int[][] dp; // Memoization array

    public static int countWays(int N, int currentPlayer, int currentMoves, int startPlayer) {
        // Base case: if currentPlayer is the startPlayer and currentMoves > 0, return 1
        if (currentPlayer == startPlayer && currentMoves > 0) {
            return 1;
        }
        
        // Check memoization table
        if (dp[currentPlayer][currentMoves] != -1) {
            return dp[currentPlayer][currentMoves];
        }
        
        // Initialize count of ways
        int ways = 0;
        
        // Check all players to pass the ball to
        for (int nextPlayer = 1; nextPlayer <= N; nextPlayer++) {
            // Check if currentPlayer can pass to nextPlayer or vice versa
            if ((currentPlayer != nextPlayer) && (currentPlayer % nextPlayer == 0 || nextPlayer % currentPlayer == 0)) {
                ways += countWays(N, nextPlayer, currentMoves + 1, startPlayer);
            }
        }
        
        // Memoize the result
        dp[currentPlayer][currentMoves] = ways;
        
        return ways;
    }

    public static int numberOfWaysToComplete(int N, int P, int X) {
        // Initialize memoization table
        dp = new int[N + 1][X + 1];
        
        // Initialize memoization table with -1 (indicating not computed)
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // Variable to store total number of ways
        int totalWays = 0;
        
        // Calculate ways for each starting player from 1 to N
        for (int startPlayer = 1; startPlayer <= N; startPlayer++) {
            totalWays += countWays(N, P, 0, startPlayer);
        }
        
        return totalWays;
    }

    public static void main(String[] args) {
        // Example 2
        int N = 3;
        int P = 2;
        int X = 4;
        System.out.println(numberOfWaysToComplete(N, P, X)); // Output: 3
    }
}
