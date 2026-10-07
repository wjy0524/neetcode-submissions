class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for(int[] interval : intervals){
            if(result.isEmpty()){
                result.add(interval);
                continue;
            }
            int[] last = result.get(result.size()-1);
            if(interval[0] <= last[1]){
                //겹침
                last[1] = Math.max(last[1], interval[1]);
            }else{
                result.add(interval);
            }
        }

        return result.toArray(new int[0][]);
    }
}
