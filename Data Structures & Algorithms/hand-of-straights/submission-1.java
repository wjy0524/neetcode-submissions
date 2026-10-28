class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> card = new TreeMap<>();
        for(int val : hand) card.put(val, card.getOrDefault(val, 0) + 1);

        while(!card.isEmpty()){
            int fVal = card.firstKey();
            for(int i=fVal; i<groupSize + fVal; i++){
                if(!card.containsKey(i)) return false;
                int cnt = card.get(i) - 1;
                if(cnt == 0){
                    card.remove(i);
                }else{
                    card.put(i, cnt);
                }
            }
        }

        return true;
    }
}
