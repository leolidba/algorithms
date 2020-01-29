package com.codersmart.algorithms.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeParser {
    public static void main(String[] args) {
        Integer[] x = {10,5,15,null,null,6,20};
        TreeNode tree = parse(x);
        printTree(tree);
    }

    public static void printTree(TreeNode root){
        System.out.println(getTree(root));
    }
    public static List<String> getTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> list = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node == null? "null": String.valueOf(node.val));
            if(node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return list;
    }

    public static TreeNode parse(Integer[] data) {
        TreeNode[] nodes = new TreeNode[data.length];
        for(int i =0; i < data.length; i++){
            if(data[i] != null) nodes[i] = new TreeNode(data[i]);
        }
        for(int i =0; i < data.length/2; i++) {
            if(nodes[i] != null){
                nodes[i].left = 2*i + 1 > data.length - 1? null : nodes[2*i + 1];
                nodes[i].right = 2*i + 2 > data.length - 1? null : nodes[2*i + 2];
            }
        }
        return nodes[0];
    }


}
