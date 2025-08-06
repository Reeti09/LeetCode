import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        
        nodeQueue.add(root);
        pathQueue.add(String.valueOf(root.val));
        
        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            String currentPath = pathQueue.poll();
            
            // Corrected line: A path is complete when we reach a leaf node.
            // We should add the 'currentPath' string, not the 'currentNode'.
            if (currentNode.left == null && currentNode.right == null) {
                paths.add(currentPath);
            }
            
            // Corrected line: Use 'currentNode.left' instead of 'currentQueue.left'.
            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
                pathQueue.add(currentPath + "->" + currentNode.left.val);
            }
            
            // Corrected line: Use 'currentNode.right' instead of 'currentQueue.right'.
            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
                pathQueue.add(currentPath + "->" + currentNode.right.val);
            }
        }
        return paths;
    }
}