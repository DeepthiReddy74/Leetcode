class MinelementAfterReplacementwithsum {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int currentSum = 0;
            int temp = num;
            while (temp > 0) {
                currentSum += temp % 10;
                temp /= 10;
            }
            if (currentSum < minSum) {
                minSum = currentSum;
            }
        }
        
        return minSum;
    }
}