class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        //hand[i]: value written on ith card 
        //consecutive group의 시작은 항상 가장 작은 수 부터
        TreeMap<Integer, Integer> cardVals = new TreeMap<>();
        for(int val : hand) cardVals.put(val, cardVals.getOrDefault(val, 0)+1);

        while(!cardVals.isEmpty()){
            int fVal = cardVals.firstKey();
            for(int i=fVal; i<fVal + groupSize; i++){
                if(!cardVals.containsKey(i)) return false;
                int curCnt = cardVals.get(i)-1;
                if(curCnt == 0){
                    cardVals.remove(i);
                }else{
                    cardVals.put(i, curCnt);
                }
            }
        }
        return true;

    }
}
