class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int[] pair: prerequisites){
                int u=pair[0];
                int v=pair[1];
                adj.get(v).add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        int index=0;
        int[] order=new int[numCourses];
        while(!q.isEmpty()){
            int u=q.poll();
            order[index++]=u;
            for(int neighbor: adj.get(u)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        if(index==numCourses){
            return order;

        }
        else{
            return new int[0];
        }
        
    }
}