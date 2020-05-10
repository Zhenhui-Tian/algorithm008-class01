//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
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

    public boolean isValidBST(TreeNode root) {
/*        if (root == null) return true;
//        if(root.left.left == null && root.left.right == null && root.right.left == null && root.right.right == null) {
//            if(root.left.val < root.val && root.right.val > root.val) {
//                return true;
//            } else {
//                return false;
//            }
//        }


        if (root.val > root.left.val && root.val < root.right.val) {
            return isValidBST(root.left) && isValidBST(root.right);
        } else {
            return false;
        }
Compile Error: java.lang.NullPointerException */
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
