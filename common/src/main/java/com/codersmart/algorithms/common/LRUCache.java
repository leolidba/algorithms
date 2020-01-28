package com.codersmart.algorithms.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    static class Node{
        Integer key;
        Integer val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity = 1;
    Map<Integer, Node> map;
    LinkedList<Node> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        list = new LinkedList<Node>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            list.remove(map.get(key));
            list.addFirst(map.get(key));
            return map.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int key, int val) {
        if(map.containsKey(key)){
            list.remove(map.get(key));
            list.addFirst(map.get(key));
            map.get(key).val = val;
            return;
        }
        if(list.size() == capacity){
            Node node = list.removeLast();
            map.remove(node.key);
        }
        Node node = new Node(key, val);
        list.addFirst(node);
        map.put(key, node);
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache( 2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }

}
