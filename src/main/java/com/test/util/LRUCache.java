package com.test.util;

import java.util.HashMap;

class LRUCache {
    int size;
    int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> hashnode=new HashMap<>();
    public static class Node{
        private Node next;
        private Node prev;
        private int key;
        private int data;
        public Node(int key,int data){
            this.key = key;
            this.data = data;
        }
        public int get(){
            return data;
        }
        public void set(int data){
            this.data=data;
        }
        public int getkey(){
            return key;
        }
        public void setkey(int key){
            this.key=key;
        }
        private Node(){}
    }
    public void changehead(Integer key){
        Node node=hashnode.get(key);
        if(head!=node){
            if(tail==node){
                //断尾
                tail=tail.prev;
                //接头
                node.next=head;
                head.prev=node;
                head=node;
            }else{
                //从链中移除
                node.next.prev=node.prev;
                node.prev.next=node.next;
                //接头
                head.prev=node;
                node.next=head;
                head=node;
            }
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
    }
    public int get(int key) {
        if(hashnode.containsKey(key)){
            //System.out.println(1);
            changehead(key);
            return hashnode.get(key).get();
        }else{
            return -1;
        }
    }

    public void put(int key, int value){
        if(!hashnode.containsKey(key)){
            if(size<capacity){
                Node node=new Node(key,value);
                hashnode.put(key,node);
                if(size==0){
                    head=node;
                    tail=node;
                }else{
                    tail.next=node;
                    node.prev=tail;
                    tail=node;
                }
                size++;
            }else{
                hashnode.remove(tail.getkey());
                tail.set(value);
                tail.setkey(key);
                hashnode.put(key,tail);
            }
            changehead(key);
        }else{
            hashnode.get(key).set(value);
            changehead(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */