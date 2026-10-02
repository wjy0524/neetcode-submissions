class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //n is the number of nums
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        //finishing counting the frequencies of each num
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        //ans
        int[] ans = new int[k];
        int ansIdx = 0;

        //bucket sort 
        //bucket[i] = arrayList where i is the freq and number goes into arrayList whose freq is if
        //why n+1? because it has to include the freq n
        List<Integer>[] bucket = new List[n+1];
        //fill up the bucket

        for(int i=1; i<=n; i++){
            bucket[i] = new ArrayList<>();
        }

        for(int key : freq.keySet()){
            bucket[freq.get(key)].add(key);
        }

        //choose k most freq nums
        for(int f=n; f>=1 && ansIdx < k; f--){
            for(int num : bucket[f]){
                ans[ansIdx] = num;
                ansIdx++;
                if(ansIdx == k) break;
            } 
        }

        return ans;

    }
}
