class Solution {
    public int[] productExceptSelf(int[] nums) {
        //자기 자신을 제외한 array의 모든 element의 곱은 prefix * suffix
        //prefix = 자신 기준 왼쪽의 곱
        //suffix = 자신 기준 오른쪽의 곱
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        suffix[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = prefix[i] * suffix[i];
        }

        return result;
        
    }
}  
