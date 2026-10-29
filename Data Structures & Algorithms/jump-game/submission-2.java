class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;

        for(int i=0; i<nums.length; i++){
            //meaning it can't reach if current location is bigger than user's max reachable location
            if(i > maxReachable) return false;
            //update the maxReachable 
            maxReachable = Math.max(maxReachable, i+nums[i]);
            if(maxReachable >= nums.length -1) return true;
        }
        return false;
    }
}
