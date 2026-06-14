class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //sort the array
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            //중복 방지
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}
