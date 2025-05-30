import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        // Step 1: Calculate distances from node1 to all reachable nodes
        int[] dist1 = bfs(n, edges, node1);

        // Step 2: Calculate distances from node2 to all reachable nodes
        int[] dist2 = bfs(n, edges, node2);

        int minDist = Integer.MAX_VALUE; // Stores the minimum of the maximum distances
        int resultNode = -1;             // Stores the index of the closest node

        // Step 3: Iterate through all nodes to find the optimal one
        for (int i = 0; i < n; i++) {
            // Check if node 'i' is reachable from both node1 and node2
            if (dist1[i] != -1 && dist2[i] != -1) {
                int currentMaxDist = Math.max(dist1[i], dist2[i]);

                // If currentMaxDist is smaller than the overall minDist, update
                if (currentMaxDist < minDist) {
                    minDist = currentMaxDist;
                    resultNode = i;
                } 
                // If currentMaxDist is equal to minDist, choose the node with the smaller index
                else if (currentMaxDist == minDist) {
                    // This condition handles the "smallest index" tie-breaker.
                    // Since we iterate from i=0 to n-1, if currentMaxDist == minDist,
                    // 'i' will naturally be greater than or equal to the current resultNode.
                    // So we only update if i < resultNode, but it's simpler to just
                    // not update if currentMaxDist is equal, as resultNode would already
                    // hold the smaller index due to iteration order.
                    // The primary check `currentMaxDist < minDist` ensures we prioritize
                    // smaller maximum distances. If they are equal, the first one encountered
                    // (which has the smallest index) will be kept.
                }
            }
        }
        return resultNode;
    }

    // Helper function to perform BFS and calculate distances from a source node
    private int[] bfs(int n, int[] edges, int startNode) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1); // Initialize distances to -1 (unreachable)

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        dist[startNode] = 0; // Distance to the start node itself is 0

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = edges[u]; // Get the next node in the path

            // If there's an outgoing edge and the next node hasn't been visited yet
            if (v != -1 && dist[v] == -1) {
                dist[v] = dist[u] + 1; // Update distance
                queue.offer(v);       // Add to queue for further traversal
            }
        }
        return dist;
    }
}