class Solution {
    List<List<Integer>> result;
    Set<List<Integer>> temp;
    List<Integer> curSubset;

    void findSubsetsTwo(int[] nums, int curIdx){
        if(curIdx == nums.length){
            //before adding it to the Set
            //sort it firest
            List<Integer> sorted = new ArrayList<>(curSubset);  // 복사본 먼저 만들고
            Collections.sort(sorted);                            // 복사본을 정렬
            temp.add(sorted);
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
        temp = new HashSet<>();
        curSubset = new ArrayList<>();
        //add the empty list
        temp.add(new ArrayList<>());

        findSubsetsTwo(nums, 0);

        result = new ArrayList<>(temp);
        return result;
    }
}

