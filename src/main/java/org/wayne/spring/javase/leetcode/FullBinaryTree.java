package org.wayne.spring.javase.leetcode;

//222.完全二叉树的节点个数

/**这道题的关键是：
 * 1、能够看出完全二叉树叶子节点存在的范围是，分层的最后一层的等比数列的差值
 * 2、叶子节点从根节点到叶子节点的路径是left还是right，是和该叶子节点的二进制位的最高位之后的第二位到最后一位对应的
 * 第二位为根节点的第一层，依次往后退，判断这个位是0还是1就能决定是left还是right，最后判断是否是空
 * 3、根据是否位空就可以采用二分查找的方式进行查找
 */

public class FullBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }

        int low = 1 << level, high = (1 << (level + 1)) -1;

        while (low < high) {
            int mid = (high - low +1)/2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid -1;
            }
        }

        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level -1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((k & bits) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits = bits >> 1;
        }
        return node != null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);
        TreeNode left3 = new TreeNode(6);

        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        right1.left = left3;

        FullBinaryTree fullBinaryTree = new FullBinaryTree();
        System.out.println(fullBinaryTree.countNodes(root));
    }
}
