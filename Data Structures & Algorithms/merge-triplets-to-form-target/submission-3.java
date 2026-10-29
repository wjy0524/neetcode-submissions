class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //일단 가능성없는 이미 x y z보다 큰 triplet은 제거
        boolean existX = false;
        boolean existY = false;
        boolean existZ = false;

        for(int[] tri : triplets){
            if(tri[0]>target[0] || tri[1] > target[1] || tri[2] > target[2]) continue;
            if(tri[0] == target[0]) existX =true;
            if(tri[1] == target[1]) existY = true;
            if(tri[2] == target[2]) existZ = true;
        }

        return existX && existY && existZ;
    }
}
