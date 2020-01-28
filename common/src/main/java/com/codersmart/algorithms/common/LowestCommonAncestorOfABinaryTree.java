package com.codersmart.algorithms.common;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> m = recursive(root, p);
        LinkedList<TreeNode> n = recursive(root, q);
        ListIterator<TreeNode> iterM = m.listIterator();
        ListIterator<TreeNode> iterN = n.listIterator();
        TreeNode lca = root;
        while(iterM.hasNext() && iterN.hasNext()){
            TreeNode next = iterM.next();
            if(next == iterN.next()){
                lca = next;
            }else{
                break;
            }
        }
        return lca;
    }

    private LinkedList<TreeNode> recursive(TreeNode root, TreeNode node) {
        if(root == null) return null;
        if(root == node){
            LinkedList<TreeNode> list = new LinkedList<>();
            list.addFirst(root);
            return list;
        }
        LinkedList list = recursive(root.left, node);
        if(list == null){
            list = recursive(root.right, node);
        }
        if(list != null){
            list.addFirst(root);
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
