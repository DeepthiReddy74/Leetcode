class Findmininrotatedarray2 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // The minimum element must be in the right unsorted part
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // The minimum element is either mid itself or to its left
                right = mid;
            } else {
                // When nums[mid] == nums[right], we can't be sure which side to eliminate.
                // However, since they are equal, we can safely skip the rightmost element.
                right--;
            }
        }
        
        return nums[left];
    }
}class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // The minimum element must be in the right unsorted part
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // The minimum element is either mid itself or to its left
                right = mid;
            } else {
                // When nums[mid] == nums[right], we can't be sure which side to eliminate.
                // However, since they are equal, we can safely skip the rightmost element.
                right--;
            }
        }
        
        return nums[left];
    }
}