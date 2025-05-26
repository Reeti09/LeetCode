class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        
        // Build the graph
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Topological sort using BFS (Kahn's Algorithm)
        Queue<Integer> queue = new LinkedList<>();
        // dp[i][c] = max count of color 'c' from source to node i
        int[][] dp = new int[n][26];
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int visited = 0;
        int result = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            // Update result with the max value in current node's color array
            for (int c = 0; c < 26; c++) {
                result = Math.max(result, dp[node][c]);
            }

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    int count = dp[node][c] + (colors.charAt(neighbor) - 'a' == c ? 1 : 0);
                    dp[neighbor][c] = Math.max(dp[neighbor][c], count);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If we didn't visit all nodes, there's a cycle
        return visited == n ? result : -1;
    }
}
