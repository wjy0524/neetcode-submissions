class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        //first of all sort nums in asending order
        Arrays.sort(nums);
        int longest = 1;
        int mxLongest = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }else if(nums[i] == nums[i-1] + 1){
                longest++;
                mxLongest = Math.max(mxLongest, longest);
            }else{
                longest = 1;
            }
        }

        return mxLongest;
        
    }
}
