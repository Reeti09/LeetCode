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
    public int getMinimumDifference(TreeNode root) {
        
        List<Integer> values=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            values.add(node.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);

        }
        Collections.sort(values);
        int n=values.size();
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            minDiff=Math.min(minDiff, values.get(i)-values.get(i-1));
        }
        return minDiff;
    }
}