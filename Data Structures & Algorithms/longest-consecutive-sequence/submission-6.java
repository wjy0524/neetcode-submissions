class Solution {
    public int longestConsecutive(int[] nums) {
        //if nums are empty list, then it should return 0;
        if(nums.length == 0) return 0;
        int longest = 1;
        int maxLongest = 1;

        //일단 nums를 sorting한다 
        //오름차순으로
        Arrays.sort(nums);
 
        int idx = 1;

        while(idx < nums.length){
            if(nums[idx] == nums[idx-1] + 1){
                longest++;
                maxLongest = Math.max(maxLongest, longest);
                idx++;
            }else if(nums[idx] == nums[idx-1]){
                idx++;
            }else{
                longest = 1;
                idx++;
            }
            
        }

        return maxLongest;

    
    }
}
