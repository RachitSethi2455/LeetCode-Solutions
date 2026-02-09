# 1382. Balance a Binary Search Tree

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/balance-a-binary-search-tree/)

`Divide and Conquer` · `Greedy` · `Tree` · `Depth-First Search` · `Binary Search Tree` · `Binary Tree`

## Approach

Accepted medium solution in java.
Relevant topics: Divide and Conquer, Greedy, Tree, Depth-First Search, Binary Search Tree, Binary Tree.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
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
```

---

**Runtime** 2 ms · **Memory** 48.3 MB

<sub>Synced by AILeetHub on 2026-02-09.</sub>
