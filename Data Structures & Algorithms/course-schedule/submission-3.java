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

        Deque<Integer> q = new ArrayDeque<>();

        int completed = 0;

        for(int i=0; i<numCourses; i++){
            if(numOfPrereq[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            completed++;
            for(int pre=0; pre<adjList.get(cur).size(); pre++){
                int nxt = adjList.get(cur).get(pre);
                numOfPrereq[nxt]--;
                if(numOfPrereq[nxt] == 0){
                    q.offer(nxt);

                }
            }
        }
        return completed == numCourses;
    }
}
