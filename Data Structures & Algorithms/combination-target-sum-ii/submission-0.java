class Solution {
    List<List<Integer>> ans;
    List<Integer> curComb;

    public void findCombSum(int[] candidates, int target, int curSum, int startIdx){
        if(curSum == target){
            ans.add(new ArrayList<>(curComb));
            return;
        }else if(curSum > target){
            return;
        }

        for(int i=startIdx; i<candidates.length; i++){
            if(i > startIdx && candidates[i] == candidates[i-1]) continue;
            curComb.add(candidates[i]);
            findCombSum(candidates, target,  curSum+candidates[i], i+1);
            curComb.remove(curComb.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        ans = new ArrayList<>();
        curComb = new ArrayList<>();
        Arrays.sort(candidates);
        findCombSum(candidates, target, 0, 0);

        return ans;
    }
}
