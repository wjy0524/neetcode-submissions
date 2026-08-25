class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create a new Map where key: nums[idx], value: idx
        //have to return the answer with the smaller idex first
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int idx=0; idx<nums.length; idx++){
            //지금 숫자를 target num에서 뺸 숫자
            int complement = target - nums[idx];
            //그 숫자가 numMap에 있으면 그건 two sum 가능
            if(numMap.containsKey(complement)){
                //have to return that index as int array
                return new int[] {numMap.get(complement), idx};
            }
            //만약 없다면 map에 올려놓는다
            numMap.put(nums[idx], idx);
        }
        //문제 조건상 그럴 경우는 없지만 만약 답이 없다면 empty int array return
        return new int[] {};
    }
}