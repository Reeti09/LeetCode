import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Step 2: Find connected components using DFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Set<Integer> nodes = new HashSet<>();
                List<int[]> edgeList = new ArrayList<>();
                dfs(i, graph, visited, nodes, edgeList);

                // Step 3: Check if it's a complete component
                int nodeCount = nodes.size();
                int expectedEdges = nodeCount * (nodeCount - 1) / 2;
                if (edgeList.size() / 2 == expectedEdges) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, Set<Integer> nodes, List<int[]> edgeList) {
        visited[node] = true;
        nodes.add(node);
        for (int neighbor : graph.get(node)) {
            edgeList.add(new int[]{node, neighbor});
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, nodes, edgeList);
            }
        }
    }
}
