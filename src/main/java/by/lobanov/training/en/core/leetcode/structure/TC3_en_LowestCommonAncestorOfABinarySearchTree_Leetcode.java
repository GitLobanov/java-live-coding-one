package by.lobanov.training.en.core.leetcode.structure;

// tags: Tree Depth-First Search Binary Search Tree Binary Tree

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find ancestor/parent
 * <br> Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * <br> Output: 6
 * <br> Explanation: The LCA of nodes 2 and 8 is 6.
 * <br> Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * <br> Output: 2
 * <br> Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class TC3_en_LowestCommonAncestorOfABinarySearchTree_Leetcode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = buildTree(arr);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println(lca.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    // for test
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (index < arr.length) {
            TreeNode current = queue.poll();

            if (arr[index] != null) {
                current.left = new TreeNode(arr[index]);
                queue.add(current.left);
            }
            index++;

            if (index < arr.length && arr[index] != null) {
                current.right = new TreeNode(arr[index]);
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }
}
