class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            minVal = Math.min(minVal, nums[i]);
        }

        return minVal;
    }
}
