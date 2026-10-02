class Solution {

    //try to aim time complexity to be O(n) using bucket sort
    //bucket[i] = { } indicating bucket[i] is the arrayList of nums whose freq is i
    public int[] topKFrequent(int[] nums, int k) {

        //n is the number of numbers
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();

        //count the freq
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucket = new List[n+1];

        for(int f=1; f<=n; f++){
            bucket[f] = new ArrayList<>();
        }

        int[] ans = new int[k];
        int ansIdx = 0;

        for(int key : freq.keySet()){
            bucket[freq.get(key)].add(key);
        }

        //make the bucket
        for(int f = n; f >= 1 && ansIdx < k; f--){  // 높은 빈도수부터
            for(int num : bucket[f]){  // 그 빈도수를 가진 숫자들
                ans[ansIdx] = num;
                ansIdx++;
                if(ansIdx == k) break;  // k개 다 모았으면 중단
            }
        }

        return ans;
    }
}
