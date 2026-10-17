class Solution {
    public int findDuplicate(int[] nums) {
        //from an index i, the next index is nums[i]
        // Every value is in the range 1 to len(nums) - 1
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int slow2 = 0;
        while(slow != slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
