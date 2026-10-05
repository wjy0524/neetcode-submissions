class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] numOfPrereq = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int prereq = pair[1];
            int course = pair[0];
            adjList.get(prereq).add(course);
            numOfPrereq[course]++;
        }

        int completed = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for(int c=0; c<numCourses; c++){
            if(numOfPrereq[c] == 0){
                q.offer(c);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            completed++;
            for(int i=0; i<adjList.get(cur).size(); i++){
                int nxt = adjList.get(cur).get(i);
                numOfPrereq[nxt]--;
                if(numOfPrereq[nxt] == 0){
                    q.offer(nxt);
                }
            }
        }

        return completed == numCourses;
    }
}
