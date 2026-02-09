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
    public TreeNode balanceBST(TreeNode root) {

        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        return build(nums, 0, nums.size() - 1);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    private TreeNode build(List<Integer> list, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(list, l, mid - 1);
        node.right = build(list, mid + 1, r);
        return node;
    }
}