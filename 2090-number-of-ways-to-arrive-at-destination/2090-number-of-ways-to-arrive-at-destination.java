import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        // Graph representation: adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Min heap for Dijkstra's (time, node)
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[] dist = new long[n];  // Shortest distance to each node
        int[] ways = new int[n];    // Number of ways to reach each node
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); // {time, node}

        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long time = cur[0];
            int u = (int) cur[1];

            if (time > dist[u]) continue; // Ignore outdated distances

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                long newTime = time + neighbor[1];

                if (newTime < dist[v]) {
                    dist[v] = newTime;
                    ways[v] = ways[u]; // Reset path count
                    pq.offer(new long[]{newTime, v});
                } else if (newTime == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD; // Add path count
                }
            }
        }

        return ways[n - 1]; // Number of ways to reach destination
    }
}
