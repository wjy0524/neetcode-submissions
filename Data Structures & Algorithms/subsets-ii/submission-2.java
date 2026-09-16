class Solution {
    List<List<Integer>> result;
    Set<List<Integer>> temp;
    List<Integer> curSubset;
    public void findSubsetTwo(int[] nums, int curIdx){
        //base case
        if(curIdx == nums.length){
            temp.add(new ArrayList<>(curSubset));
            return;
        }

        //curIdx에 있는 num 포함 시키기
        curSubset.add(nums[curIdx]);
        findSubsetTwo(nums, curIdx+1);
        //backtrack
        //remove nums[curIdx]
        curSubset.remove(curSubset.size()-1);
        //없는 경우
        //같은 거면 skip
        while(curIdx + 1 < nums.length && nums[curIdx] == nums[curIdx+1]){
            curIdx++;
        }
        findSubsetTwo(nums, curIdx+1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        temp = new HashSet<>();
        curSubset = new ArrayList<>();

        Arrays.sort(nums);

        temp.add(new ArrayList<>());

        findSubsetTwo(nums, 0);

        result = new ArrayList<>(temp);

        return result;
    }
}
