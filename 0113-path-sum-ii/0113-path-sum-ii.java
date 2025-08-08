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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> currentPath=new ArrayList<>();
        dfs(root, targetSum, result, currentPath);
        return result;

    }
    private void dfs(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> currentPath){
        if(node==null){
            return;
        }
        currentPath.add(node.val);
        if(node.left==null && node.right==null && targetSum==node.val){
            result.add(new ArrayList<>(currentPath));

        }
        dfs(node.left, targetSum-node.val, result, currentPath);
        dfs(node.right, targetSum-node.val, result, currentPath);
        currentPath.remove(currentPath.size()-1);
    }
}