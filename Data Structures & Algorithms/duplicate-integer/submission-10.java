class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int i=0;
        while(i < nums.length){
            if(map.containsKey(nums[i])) return true;
            map.put(nums[i], 1);
            i++;
        }

        return false;
    }
}