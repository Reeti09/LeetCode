/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode, TreeNode> parentMap;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap=new HashMap<>();
        findParents(root, null);
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        queue.add(target);
        visited.add(target);
        int dist=0;
        while(!queue.isEmpty()){
            if(dist==k){
                List<Integer> result=new ArrayList<>();
                while(!queue.isEmpty()){
                    result.add(queue.poll().val);
                }
                return result;
            }
            int level=queue.size();
            for(int i=0;i<level;i++){
                TreeNode current=queue.poll();
                if(current.left!=null && !visited.contains(current.left)){
                    queue.add(current.left);
                    visited.add(current.left);
                }
                if(current.right!=null && !visited.contains(current.right)){
                    queue.add(current.right);
                    visited.add(current.right);
                }
                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
            dist++;

        }
        return new ArrayList<>();
    }
    private void findParents(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (parent != null) {
            parentMap.put(node, parent);
        }
        findParents(node.left, node);
        findParents(node.right, node);
    }
}