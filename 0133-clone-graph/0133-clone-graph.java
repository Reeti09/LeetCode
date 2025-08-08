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
        if(node==null) return null;
        Map<Node, Node> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        Node clonedStart=new Node(node.val);
        visited.put(node, clonedStart);
        q.add(node);
        while(!q.isEmpty()){
            Node originalNode=q.poll();
            Node clonedNode=visited.get(originalNode);
            for(Node neighbor: originalNode.neighbors){
                if(!visited.containsKey(neighbor)){
                    Node clonedNeighbor=new Node(neighbor.val);
                    visited.put(neighbor, clonedNeighbor);
                    q.add(neighbor);
                }
                clonedNode.neighbors.add(visited.get(neighbor));

            }
        }
        return clonedStart;
        
    }
}