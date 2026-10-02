class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int j, k;
        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            j = i+1;
            k = n-1;

            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> oneComb = new ArrayList<>();
                    oneComb.add(nums[i]);
                    oneComb.add(nums[j]);
                    oneComb.add(nums[k]);
                    result.add(oneComb);
                    j++;
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                }else if(sum>0){
                    k--;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }else{
                    j++;
                     while(j<k && nums[j] == nums[j-1]) j++;
                }
            }
        }

        return result;
    }
}
