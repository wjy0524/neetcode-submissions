class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> numSet = new ArrayList<>();

        for(int num : nums){
            if(numSet.contains(num)){
                return true;
            }

            numSet.add(num);
        }
        return false;
    }
}