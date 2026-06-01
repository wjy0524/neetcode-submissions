class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> numSet = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(numSet.contains(nums[i])){
                return true;
            }
            numSet.add(nums[i]);
        }

        return false;
        
    }
}