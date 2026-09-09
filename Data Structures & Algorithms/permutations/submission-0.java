class Solution {
    List<List<Integer>> result;
    List<Integer> permute;

    void findPermute(int[] nums, int currSelected){
        if(currSelected == nums.length){
            result.add(new ArrayList<>(permute));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(permute.contains(nums[i])) continue;
            permute.add(nums[i]);
            findPermute(nums, currSelected+1);
            permute.remove(permute.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permute = new ArrayList<>();
        findPermute(nums, 0);

        return result;
    }
}
