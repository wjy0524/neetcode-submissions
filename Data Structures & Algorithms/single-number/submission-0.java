class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> bit = new HashSet<>();

        for(int n : nums){
            if(!bit.contains(n)){
                bit.add(n);
            }else{
                bit.remove(n);
            }
        }

        return bit.iterator().next();
    }
}
