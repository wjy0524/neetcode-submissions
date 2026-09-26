class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //indegree[i] = the number of prereq to take ith class
        int[] indegree = new int[numCourses];
        //have to make a graph first
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int idx=0; idx<prerequisites.length; idx++){
            int prereq = prerequisites[idx][1];
            int course = prerequisites[idx][0];
            adjList.get(prereq).add(course);
            indegree[course]++;
        }

        int[]ordering = new int[numCourses];

        Deque<Integer> q = new ArrayDeque<>();


        //put all the courses with indegree 0 onto Queue
        for(int c=0; c<numCourses; c++){
            if(indegree[c] == 0){
                q.offer(c);
            }
        }

        int completed = 0;

        while(!q.isEmpty()){
            int curCourse = q.poll();
            ordering[completed] = curCourse;
            completed++;
            for(int pre=0; pre<adjList.get(curCourse).size(); pre++){
                int nxtCourse = adjList.get(curCourse).get(pre);
                indegree[nxtCourse]--;
                if(indegree[nxtCourse] == 0){
                    q.offer(nxtCourse);
                }
            }
            
        }

        if(completed != numCourses){
            return new int[0];
        }

        
        return ordering;
        
    }
}
