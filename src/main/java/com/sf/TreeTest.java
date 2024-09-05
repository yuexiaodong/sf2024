package com.sf;

public class TreeTest {

    public static void main(String[] args) {

    }

    // lc:98 bst判断
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }
        boolean leftCheck = check(node.left, min, node.val);
        boolean rightCheck = check(node.right, node.val, max);
        return leftCheck && rightCheck;
    }


}
