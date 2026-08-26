class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        //key: number, value: frequencies
        //count the frequencies of each number
        for(int num : nums){
            if(freq.containsKey(num)){
                freq.put(num, freq.get(num) + 1);
            }else{
                freq.put(num, 1);
            }
        }

        Integer[] keys = freq.keySet().toArray(new Integer[0]);

        Arrays.sort(keys, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return freq.get(b) - freq.get(a); //내림차순
            }
        });

        int[] answers = new int[k];
        for(int i=0; i<k; i++){
            answers[i] = keys[i];
        }

        return answers;
        
    }
}
