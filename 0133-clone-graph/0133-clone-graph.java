/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clone = new Node(node.val);
        visited.put(node, clone);
        q.add(node);

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (Node neighbor : current.neighbors) { // ✅ Corrected spelling: "neighbors"
                if (!visited.containsKey(neighbor)) {
                    Node neighborClone = new Node(neighbor.val); // ✅ Corrected spelling: "neighborClone"
                    visited.put(neighbor, neighborClone);
                    q.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
