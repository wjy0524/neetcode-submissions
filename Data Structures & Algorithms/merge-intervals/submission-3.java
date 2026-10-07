class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));


        for(int[] interval : intervals){
            if(result.isEmpty()) result.add(interval);

            int[] last = result.get(result.size()-1);
            if(last[1] >= interval[0]){
                //겹치면
                last[1] = Math.max(last[1], interval[1]);
            }else{
                result.add(interval);
            }
        }

        return result.toArray(new int[0][]);
    }
}
