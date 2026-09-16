class Solution {
    List<List<Integer>> result;
    Set<List<Integer>> temp;
    List<Integer> curSubset;

    void findSubsetsTwo(int[] nums, int curIdx){
        if(curIdx == nums.length){
            temp.add(new ArrayList<>(curSubset));
            return;
        }

        curSubset.add(nums[curIdx]);
        findSubsetsTwo(nums, curIdx+1);
        //되돌리기
        curSubset.remove(curSubset.size()-1); 
        // 선택 2: nums[curIdx]를 포함 안 함
        findSubsetsTwo(nums, curIdx+1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        temp = new HashSet<>();
        curSubset = new ArrayList<>();
        //add the empty list
        temp.add(new ArrayList<>());

        findSubsetsTwo(nums, 0);

        result = new ArrayList<>(temp);
        return result;
    }
}

