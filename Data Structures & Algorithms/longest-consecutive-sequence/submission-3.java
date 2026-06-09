class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        int counter = 1;
        Arrays.sort(nums);
        int greatest = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if(greatest < counter) greatest = counter;
            if(!(nums[i] == nums[i-1] + 1)){
                counter = 0;
            }
            counter++;
        }
        if(greatest < counter) greatest = counter;

        return greatest;
    }
}
