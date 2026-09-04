class Solution {
    List<List<Integer>> ans;
    List<Integer> curSubset;

    void findSubsets(int[] nums, int curIdx){
        //base case
        if(curIdx == nums.length){
            ans.add(new ArrayList<>(curSubset));
            return;
        }

        curSubset.add(nums[curIdx]);
        findSubsets(nums, curIdx+1);
        curSubset.remove(curSubset.size()-1);  // 되돌리기!
        // 선택 2: nums[curIdx]를 포함 안 함
        findSubsets(nums, curIdx+1);

        
    }


    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();

        curSubset = new ArrayList<>();
        findSubsets(nums, 0);

        return ans;
    }
}
