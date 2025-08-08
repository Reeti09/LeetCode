class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree=new int[numCourses];
        for(int[] prereq: prerequisites){
            int course=prereq[0];
            int preCourse=prereq[1];
            adj.get(preCourse).add(course);
            inDegree[course]++;

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int[] result=new int[numCourses];
        int count=0;
        while(!q.isEmpty()){
            int course=q.poll();
            result[count++]=course;
            for(int nextCourse: adj.get(course)){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse]==0){
                    q.add(nextCourse);
                }

            }
        }
        if(count==numCourses){
            return result;
        }
        else{
            return new int[0];
        }

    }
}