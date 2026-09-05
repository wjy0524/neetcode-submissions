class Solution {
    List<List<Integer>> ans;
    Set<List<Integer>> combSum;
    List<Integer> curComb;

    public void findCombSum(int[] nums, int target, int curSum, int startIdx){
        if(curSum == target){
            ans.add(new ArrayList<>(curComb)); 
            return;
        }else if(curSum > target){
            return;
        }

        for(int i=startIdx; i<nums.length; i++){
            curComb.add(nums[i]);
            findCombSum(nums, target, curSum + nums[i], i);
            curComb.remove(curComb.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        curComb = new ArrayList<>();
        findCombSum(nums, target, 0, 0);

        return ans;
    }   
}
