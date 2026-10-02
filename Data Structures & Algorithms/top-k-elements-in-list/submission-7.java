class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        //Key: num value: freq
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        //num is 1 to n so make the list size as n+1 to include n
        //bucket[i] = val 
        //i isthe freq and val is the num whose freq is i
        List<Integer>[] bucket = new List[n+1];

        int[] ans = new int[k];
        int ansIdx = 0;

        for(int i=1; i<=n; i++){
            bucket[i] = new ArrayList<>();
        }

        for(int key : freq.keySet()){
            bucket[freq.get(key)].add(key);
        }

        for(int f=n; f>=1 && ansIdx < k; f--){
            for(int num : bucket[f]){
                if(ansIdx<k){
                    ans[ansIdx] = num;
                    ansIdx++;
                }
            }
        }

        return ans;
    }
}
