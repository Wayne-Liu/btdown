package org.wayne.spring.javase.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);

            return Math.max(leftDepth,rightDepth) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null ) {
            return 0;
        } else {
            int num = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size --;
                }

                num ++;
            }
            return num;
        }
    }

    public static void main(String[] args) {
        int[] tree = {3,9,20,0,0,15,7};
        TreeMaxDepth treeMaxDepth = new TreeMaxDepth();

        TreeNode root = treeMaxDepth.translateToTree(tree);
        System.out.println(treeMaxDepth.maxDepth2(root));
    }

    TreeNode translateToTree(int[] tree) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 3;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 9;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 20;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val = 15;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.val = 7;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        return treeNode1;
    }

}
