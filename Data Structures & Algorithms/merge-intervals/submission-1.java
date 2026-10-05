class Solution {
    public int[][] merge(int[][] intervals) {
        //we not sure how many intervals at then there would be 
        //so start with ArrayList
        List<int[]> result = new ArrayList<>();

        //sort the intervals by the starting point in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        //so basically how it works iterate through each interval in intervals
        //if the result is empty, you put the interval in it
        for(int[] interval : intervals){
            if(result.isEmpty()){
                result.add(interval);
                continue;
            }
            //you take the last interval from result and compare it with interval
            //compare interval's start with last's end 
            int[] last = result.get(result.size()-1);
            if(interval[0] <= last[1]){
                //then they overlap
                //now have to set the end by comparing and picking max
                last[1] = Math.max(last[1], interval[1]);
            }else{
                //if they don't overlap you add it to result
                result.add(interval);
            }
        }
        return result.toArray(new int[0][]);
    }
}
