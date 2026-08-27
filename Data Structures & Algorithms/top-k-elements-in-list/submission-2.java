class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //frequency를 나타내는 Map을 만들자
        //key: number, value: frequencies
        //그리고 key들을 arrayList에 넣고 정렬 할건데
        //정렬 방법을 내가 override해서 정해줘야함
        //정렬 방법: value가 큰 순서대로
        //그 이후에 k 만큼 앞에서 부터 뺴면 된다
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            if(freq.containsKey(num)){
                freq.put(num, freq.get(num) + 1);
            }else{
                freq.put(num, 1);
            }
        }

        //key로 arrayList만들고
        List<Integer> keys = new ArrayList<>(freq.keySet());
        //frequency 높은 것 부터 내림차순으로 정렬
        keys.sort((a, b) -> freq.get(b) - freq.get(a));  

        int[] answer = new int[k];

        for(int i=0; i<k; i++){
            answer[i] = keys.get(i);
        }

        return answer;
    }
}
