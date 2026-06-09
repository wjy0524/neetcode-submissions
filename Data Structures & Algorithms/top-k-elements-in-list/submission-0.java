class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(freq.containsKey(nums[i])){
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }else{
                freq.put(nums[i], 1);
            }
        }

        // map freq을 이제 array로 바꿔서 sort하면 됨
        // Integer[] 타입으로 받고 싶으면 힌트 필요
        //그래서 new Integer[0]을 씀으로써 Integer[] 타입으로 받는 다는 걸 알려줌
        Integer[] keys = freq.keySet().toArray(new Integer[0]);
        //override로 내림챃순으로 해주고 
        //default가 오름차순이므로 Override로 내림차순 compare로 만들어줘야함
        Arrays.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
            return freq.get(b) - freq.get(a); // 내림차순
            }
        });
        int[] answers = new int[k];
        for(int i=0; i<k; i++){
            answers[i] = keys[i];
        }

        return answers;
    }
}
