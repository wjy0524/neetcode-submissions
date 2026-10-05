class Solution {
    List<List<Integer>> answer;
    List<Integer> curComb;

    public void findAllComb(int[] nums, int target, int curSum, int startIdx){
        //base case when curSum == target
        if(curSum == target){
            answer.add(new ArrayList<>(curComb));
            return;
        }else if(curSum > target){
            return;
        }

        for(int i=startIdx; i<nums.length; i++){
            curComb.add(nums[i]);
            findAllComb(nums, target, curSum+nums[i], i);
            curComb.remove(curComb.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        answer = new ArrayList<>();
        curComb = new ArrayList<>();

        findAllComb(nums, target, 0, 0);

        return answer;
        
    }
}
