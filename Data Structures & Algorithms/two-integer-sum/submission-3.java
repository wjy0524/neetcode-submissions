class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int idx = 0; idx<nums.length; idx++){
            int complement = target - nums[idx];
            if(numMap.containsKey(complement)){
                return new int[] {numMap.get(complement), idx};
            }
            
            numMap.put(nums[idx], idx);
        }
        
        return new int[]{};
    }
}