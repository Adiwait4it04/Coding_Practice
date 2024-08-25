public class target {
    public static void main(String[] args) {
        int numbers[] = {4, 2, 7, 1, 3}; 
        int target = 10;

        // Initialize dp array with false
        boolean dp[][] = new boolean[numbers.length + 1][target + 1];

        // Base case: target sum 0 can always be achieved with an empty subset
        for (int i = 0; i <= numbers.length; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = 1; j <= target; j++) {
                int v = numbers[i - 1];
                if (v <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - v];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Output the result for the full array and target sum
        System.out.println("Subset with sum " + target + " exists: " + dp[numbers.length][target]);
    }

    public static boolean subset(int numbers[], Boolean dp[][], int n, int target) {
        // Base cases
        if (target == 0) {
            return true; // If target is 0, empty subset always works
        }
        if (n == 0) {
            return false; // If no items left, can't form a non-zero target
        }

        // If the value is already computed
        if (dp[n][target] != null) {
            return dp[n][target];
        }

        // If the current number is less than or equal to target, consider it
        if (numbers[n - 1] <= target) {
            // Check if we can form the target either by including or excluding the current number
            boolean include = subset(numbers, dp, n - 1, target - numbers[n - 1]);
            boolean exclude = subset(numbers, dp, n - 1, target);
            dp[n][target] = include || exclude;
        } else {
            // If the current number is greater than the target, skip it
            dp[n][target] = subset(numbers, dp, n - 1, target);
        }

        return dp[n][target];
    }
}
