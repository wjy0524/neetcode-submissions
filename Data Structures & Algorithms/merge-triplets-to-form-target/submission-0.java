class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // n is the number of triplets
        int n = triplets.length;
        List<int[]> validTriplets = new ArrayList<>();
        for(int t=0; t<n; t++){
            if(triplets[t][0] > target[0] || triplets[t][1] > target[1] || triplets[t][2] > target[2]) continue;
            validTriplets.add(triplets[t]);
        }

        boolean fExist = false;
        boolean sExist = false;
        boolean tExist = false;

        for(int[] triplet : validTriplets){
            if(triplet[0] == target[0]) fExist = true;
            if(triplet[1] == target[1]) sExist = true;
            if(triplet[2] == target[2]) tExist = true;
        }

        return fExist && sExist && tExist;
    }
}
