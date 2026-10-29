class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasBalance = 0;
        int resultIdx =0;
        //to figure out if there's an possible way, no matter where you start
        //total balance shouldn't be negative
        int total = 0;

        for(int i=0; i<gas.length; i++){
            gasBalance += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if(gasBalance < 0){
                gasBalance = 0;
                resultIdx = i+1;
            }
        }

        if(total < 0) return -1;
        return resultIdx;

    }
}
