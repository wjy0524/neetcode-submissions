class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> numSet = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(numSet.containsKey(nums[i])){
                return true;
            }

            numSet.put(nums[i], i);
        }
        return false;
    }
}