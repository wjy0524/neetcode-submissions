class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //result to return
        List<List<Integer>> result = new ArrayList<>();

        //sort nums in ascending order
        Arrays.sort(nums);

        int j, k;

        for(int i=0; i<n-2; i++){
            j = i+1;
            k = n-1;
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> oneComb = Arrays.asList(nums[i], nums[j], nums[k]);
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
