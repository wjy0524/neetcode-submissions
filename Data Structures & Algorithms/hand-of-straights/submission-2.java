class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> cardVals = new TreeMap<>();

        for(int val : hand) cardVals.put(val, cardVals.getOrDefault(val, 0)+1);

        while(!cardVals.isEmpty()){
            int fNum = cardVals.firstKey();
            for(int i=0; i<groupSize; i++){
                if(!cardVals.containsKey(fNum)) return false;
                int cnt = cardVals.get(fNum)-1;
                cardVals.put(fNum, cnt);
                if(cnt == 0){
                    cardVals.remove(fNum);
                }
                fNum++;
            }
        }

        return true;
        
    }
}
