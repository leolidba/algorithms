package com.codersmart.algorithms.common;

public class BinarySearchTreeValidation {
    public static void main(String[] args) {
        Integer[] data = {10,5,15,null,null,6,20};
        TreeNode root = TreeParser.parse(data);
        TreeParser.printTree(root);
        System.out.println(new BinarySearchTreeValidation().isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validateBST(TreeNode root, Long lowerExclusive, Long upperExclusive){
        if(root == null) return true;
        if(root.val <= lowerExclusive || root.val >= upperExclusive ) return false;

        boolean result = true;
        if(root.left != null){
            result = validateBST(root.left, Math.min(lowerExclusive, root.val),
                    Math.min(root.val, upperExclusive));
        }
        if(result && root.right != null){
            result = validateBST(root.right, Math.max(lowerExclusive, root.val),
                    Math.max(root.val, upperExclusive));
        }
        return result;
    }
}
