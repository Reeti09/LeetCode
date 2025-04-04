class Solution {
    static class Pair {
        TreeNode node;
        int depth;
        
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return findLCA(root, 0).node;
    }
    
    private Pair findLCA(TreeNode node, int depth) {
        if (node == null) return new Pair(null, depth);
        
        Pair left = findLCA(node.left, depth + 1);
        Pair right = findLCA(node.right, depth + 1);
        
        if (left.depth == right.depth) {
            return new Pair(node, left.depth); // LCA found
        }
        
        return left.depth > right.depth ? left : right; // Return deeper subtree
    }
}
