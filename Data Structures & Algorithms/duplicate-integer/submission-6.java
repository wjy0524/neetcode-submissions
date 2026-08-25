class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> numSet = new ArrayList<>();
       //iterate through each number in nums
       for(int num : nums){
            if(numSet.contains(num)){
                return true;
            }
            numSet.add(num);
       }

       //위에 안걸렸다는건 duplicate이 없는거임
       return false;
    }
}