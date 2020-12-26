package org.limdongjin.problems;

import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicateElement {
    private LinkedList<Integer> linkedList;

    protected class LinkedList<Item> implements Iterable {
        private Node<Item> head;
        private Node<Item> tail;
        private int n = 0;
        
        public void addFirst(Item item) {
            Node<Item> node = new Node<Item>(item, null);
            
            if (isEmpty()) {
                head = tail = node;
                n++;
                return;
            }
            n++;
            tail.next = node;
            tail = node;
        }

        public boolean isEmpty() {
            return this.n == 0;
        }

        public void removeIfDuplicate() {
            HashSet<Item> set = new HashSet<>();
            Node cur = head;
            set.add((Item)cur.val);
            while (cur.next != null) {
                if (!set.contains(cur.next.val)) {
                    set.add((Item)cur.next.val);
                    cur = cur.next;
                    continue;
                }
                cur.next = cur.next.next;
            }
        }

        public Iterator<Item> iterator() {
            return new Iterator<Item>() {
                Node<Item> cur = head;
                @Override
                public boolean hasNext(){
                    return cur != null;
                }
                @Override
                public Item next(){
                    Item nextVal = cur.val;
                    cur = cur.next;
                    return nextVal;
                }
            };
        }
        
        protected class Node<Item> {
            protected Item val;
            protected Node<Item> next;

            public Node(Item val, Node<Item> next) {
                this.val = val;
                this.next = next;
            }
        }
    }

    public RemoveDuplicateElement(){
        linkedList = new LinkedList<Integer>();
    }
    private void before_run(){
        
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(3);
        linkedList.addFirst(1);
        linkedList.addFirst(111);
        linkedList.addFirst(3);
        linkedList.addFirst(1);
    }
    private void run(){
        before_run();
        
        System.out.println("Before");
        for(var val : linkedList)
            System.out.println(val);
        
        System.out.println("Afrer");
        linkedList.removeIfDuplicate();
        for(var val : linkedList)
            System.out.println(val);
    }
    public static void main(String[] args){
        System.out.println("*problem: remove duplicated element from linkedlist*");
        RemoveDuplicateElement app = new RemoveDuplicateElement();
        app.run();

    }
}
