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
// do inorder traversal and just see 

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();

    void dfs(TreeNode root){
        if(root == null)
            return;

        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);

    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);

        for(int i=1;i<arr.size();i++){
            if(arr.get(i) <= arr.get(i - 1))
                return false;
            
        }

        return true;
    }
}
