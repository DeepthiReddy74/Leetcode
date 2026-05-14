class Checkifarrayisgood {
    public boolean isGood(int[] nums) {
        int len = nums.length;
        int n = len - 1;
        
        if (len < 2) {
            return false;
        }
        
        int[] count = new int[n + 1];     
        for (int num : nums) {
            if (num < 1 || num > n) {
                return false;
            }
            count[num]++;
        }
        
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        
        return count[n] == 2;
    }
}