import java.util.Arrays;

public class knap {
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int weight[] = {2, 5, 1, 3, 4};
        int dp[][] = new int[weight.length + 1][8];
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        // int maxProfit = knapsacak(val, weight, val.length, 7, dp);
        // System.out.println("Maximum Profit: " + maxProfit);
        // printDpTable(dp);
    }
 
    public static int knapsacak(int val[], int wt[], int n, int W, int dp[][]) {
        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if(n == 0 || W == 0) {
            dp[n][W] = 0;
            return 0;
        }

        if(wt[n - 1] <= W) {
            int inc = val[n - 1] + knapsacak(val, wt, n - 1, W - wt[n - 1], dp);
            int exc = knapsacak(val, wt, n - 1, W, dp);
            dp[n][W] = Math.max(inc, exc);
        } else {
            dp[n][W] = knapsacak(val, wt, n - 1, W, dp);
        }

        printDpTable(dp); // Print DP table after each update
        return dp[n][W];
    }

    public static void printDpTable(int[][] dp) {
        System.out.println("DP Table:");
        for(int[] row : dp) {
            for(int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
