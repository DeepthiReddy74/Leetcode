import java.util.Arrays;
class Solution {
    private int[] memo;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        int maxVisited = 0;
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, n, d, i));
        }
        return maxVisited;
    }
    private int dfs(int[] arr, int n, int d, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }
        int currentMax = 1; 
        for (int x = 1; x <= d; x++) {
            int j = i + x;
            if (j >= n || arr[j] >= arr[i]) {
                break; 
            }
            currentMax = Math.max(currentMax, 1 + dfs(arr, n, d, j));
        }
        for (int x = 1; x <= d; x++) {
            int j = i - x;
            if (j < 0 || arr[j] >= arr[i]) {
                break; 
            }
            currentMax = Math.max(currentMax, 1 + dfs(arr, n, d, j));
        }

        memo[i] = currentMax;
        return memo[i];
    }
}