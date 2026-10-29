class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        List<int[]> validT = new ArrayList<>();
        for(int[] t : triplets){
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            validT.add(t);
        }

        boolean fExist = false;
        boolean sExist = false;
        boolean tExist = false;

        for(int[] t : validT){
            if(t[0] == target[0]) fExist = true;
            if(t[1] == target[1]) sExist = true;
            if(t[2] == target[2]) tExist = true;
        }

        return fExist && sExist && tExist;
    }
}
