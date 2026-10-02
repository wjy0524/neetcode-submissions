class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        //hashmap where key is num, and value is frequency
        Map<Integer, Integer> freq = new HashMap<>();

        //I put all the freq into the map
        for(int num : nums){
            if(!freq.containsKey(num)){
                freq.put(num, 1);
            }else{
                freq.put(num, freq.get(num)+1);
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(freq.keySet());
        sortedKeys.sort((k1, k2) -> Integer.compare(freq.get(k2), freq.get(k1)));

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = sortedKeys.get(i);
        }

        return ans;
    }
}
