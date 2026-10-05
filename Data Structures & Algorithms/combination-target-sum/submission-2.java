class Solution {
    List<List<Integer>> answer;
    List<Integer> curComb;

    private void findAllComb(int[] nums, int target, int curSum, int startIdx){
        if(curSum == target){
            answer.add(new ArrayList<>(curComb));
            return;
        }

        for(int i=startIdx; i<nums.length; i++){
            if(curSum + nums[i] > target) break;
            curComb.add(nums[i]);
            findAllComb(nums, target, curSum + nums[i], i);
            curComb.remove(curComb.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        answer = new ArrayList<>();
        curComb = new ArrayList<>();

        Arrays.sort(nums);

        findAllComb(nums, target, 0, 0);

        return answer;
    }
}
