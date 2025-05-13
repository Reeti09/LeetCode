/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack=new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
        
    }
    private void pushLeft(TreeNode node) {
    while (node != null) {
        stack.push(node);       // push current node
        node = node.left;       // go to left subtree
    }
}
    
    public int next() {
        TreeNode cur=stack.pop();
        if(cur.right!=null){
            pushLeft(cur.right);
        }
        return cur.val;
        
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */