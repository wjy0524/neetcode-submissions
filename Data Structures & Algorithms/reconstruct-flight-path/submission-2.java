class Solution {
    Map<String, PriorityQueue<String>> flightMap = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        //map을 만들자
        for(List<String> t : tickets){
            flightMap.computeIfAbsent(t.get(0), x -> new PriorityQueue<>()).offer(t.get(1));
        }
        dfs("JFK");
        return res;
    }
    void dfs(String start){
        PriorityQueue<String> dests = flightMap.get(start);
        while(dests != null && !dests.isEmpty()){
            dfs(dests.poll());
        }
        res.addFirst(start);
    }
}
