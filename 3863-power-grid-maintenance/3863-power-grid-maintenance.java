import java.util.*;

class Solution {
    private int[] parent;
    // Map to store the set of ALL online node IDs in the component rooted by the key
    private Map<Integer, TreeSet<Integer>> onlineNodes; 
    private boolean[] is_online; 

    private void initDSU(int c) {
        parent = new int[c + 1];
        is_online = new boolean[c + 1];
        onlineNodes = new HashMap<>();
        
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
            is_online[i] = true;
            TreeSet<Integer> set = new TreeSet<>();
            set.add(i);
            onlineNodes.put(i, set);
        }
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); 
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            // Merge the smaller set into the larger one (optimization)
            if (onlineNodes.get(rootI).size() < onlineNodes.get(rootJ).size()) {
                int temp = rootI; rootI = rootJ; rootJ = temp;
            }
            
            // Move elements from rootJ's set to rootI's set
            onlineNodes.get(rootI).addAll(onlineNodes.get(rootJ));
            onlineNodes.remove(rootJ); // Remove the merged set
            parent[rootJ] = rootI;
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        initDSU(c);
        
        // 1. Establish initial power grids (Union all connections)
        for (int[] conn : connections) {
            union(conn[0], conn[1]);
        }
        
        List<Integer> results = new ArrayList<>();
        
        // 2. Process queries
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];

            if (type == 1) { // Query [1, x]: Maintenance Check
                if (is_online[x]) {
                    results.add(x);
                } else {
                    int root = find(x);
                    TreeSet<Integer> currentOnline = onlineNodes.get(root);
                    
                    if (currentOnline != null && !currentOnline.isEmpty()) {
                        // TreeSet's first() gives the smallest element (lowest ID)
                        results.add(currentOnline.first());
                    } else {
                        // No operational station exists
                        results.add(-1);
                    }
                }
            } else { // Query [2, x]: Station x goes Offline
                if (is_online[x]) { // Only process if it was previously online
                    is_online[x] = false;
                    int root = find(x);
                    
                    // Remove the now-offline node from the root's set of online nodes
                    if (onlineNodes.containsKey(root)) {
                        onlineNodes.get(root).remove(x);
                    }
                }
            }
        }
        
        return results.stream().mapToInt(i -> i).toArray();
    }
}