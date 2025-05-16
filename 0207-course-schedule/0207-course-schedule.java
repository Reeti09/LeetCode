class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build the graph (v → u, i.e., prerequisite to course)
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
        }

        // Step 3: Compute in-degrees
        int[] inDegree = new int[numCourses];  // ⚠️ Was named `indegree` in declaration but used as `inDegree` later. Fixed to be consistent.
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Step 4: Add all nodes with in-degree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.add(i); // ⚠️ Case-sensitive variable name fixed
        }

        // Step 5: Process the queue
        int c = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            c++;

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor); // ✅ Missing step in your code: add neighbor if in-degree becomes 0
                }
            }
        }

        // Step 6: If all nodes are processed, return true
        return c == numCourses;
    }
}
