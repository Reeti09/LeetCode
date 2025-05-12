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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length) return null;
        Map<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, hm);
    }
    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> hm){
        if(ps>pe || is>ie) return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int inRoot=hm.get(postorder[pe]);
        int numleft=inRoot-is;
        root.left=build(inorder, is, inRoot-1, postorder, ps, ps+numleft-1, hm);
        root.right=build(inorder, inRoot+1, ie,postorder, ps+numleft,pe-1, hm);
        return root;
    }
}