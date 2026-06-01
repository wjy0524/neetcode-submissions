class Solution {
    public int[] twoSum(int[] nums, int target) {
        //숫자들 index 접근을 편하게 하기 위해 map
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(numMap.containsKey(complement)){
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        //답이 없으면 empty array를 return
        return new int[]{};
    }
}
