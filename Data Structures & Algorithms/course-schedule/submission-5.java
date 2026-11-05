class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        int[] numOfPrereq = new int[numCourses];

        for(int[] p : prerequisites){
            int prereq = p[1];
            int course = p[0];
            adjList.get(prereq).add(course);
            numOfPrereq[course]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        //put all courses who don't have prerequisite onto Queue
        for(int c=0; c<numCourses; c++){
            if(numOfPrereq[c] == 0){
                q.offer(c);
            }
        }

        int completed =0;

        while(!q.isEmpty()){
            int curCourse = q.poll();
            completed++;
            for(int nxtCourse : adjList.get(curCourse)){
                numOfPrereq[nxtCourse]--;
                //now you can take that course
                if(numOfPrereq[nxtCourse] == 0){
                    //offer onto Queue
                    q.offer(nxtCourse);
                }
            }
        }

        return numCourses == completed;
    }
}
