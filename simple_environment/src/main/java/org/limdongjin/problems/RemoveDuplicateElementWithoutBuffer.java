package org.limdongjin.problems;

import java.util.Iterator;

class RemoveDuplicateElementWitoutBuffer {
    
    private LinkedList<Integer> linkedList;

    protected class LinkedList<Item> implements Iterable {
        private Node<Item> head;
        private Node<Item> tail;

        public void printList(){
            for(var elem : this)
                System.out.printf("%d ", elem);
            System.out.println();
        }
        
        private class LinkedIterator<Item> implements Iterator<Item> {
                private Node<Item> cur;
                private LinkedIterator(final Node<Item> cur){
                    this.cur = cur;
                }
                @Override
                public boolean hasNext() {
                    return cur != null;
                }
                @Override
                public Item next() {
                    final Item item = cur.val;
                    cur = cur.next;
                    return item; 
                }
        }
        public Iterator<Item> iterator(){
            return new LinkedIterator(head);
        }
        protected void removeIfDuplicate(){
            Node cur = head;
            //printList();
            while(cur.next != null){
                Node cur2 = cur;
                final Item target = (Item)cur.val;
                // System.out.printf("Target: %d\n", target);
                while(cur2.next != null){
                    // System.out.printf("Cur2: %d, Cur2.next: %d\n", cur2.val, cur2.next.val);
                    if(cur2.next.val == target){
                        // System.out.println("Cur2.next = cur2.next.next ");
                        //if(cur2.next.next != null){
                        //    System.out.print("Cur2.next.next = ");
                        //    System.out.println(cur2.next.next.val);
                        //}
                        cur2.next = cur2.next.next;
                        
                        continue;
                    }
                    cur2 = cur2.next;
                    
                }
                //for(var a : this)
                //    System.out.printf("%d ", a);
                //System.out.println();
                cur = cur.next;
            }
        }
        protected void addFirst(final Item item){
            final Node<Item> node = new Node(item, null);
            if(isEmpty()){
                head = tail = node;
                return;
            }
            tail.next = node;
            tail = node;
        }
        protected boolean isEmpty(){
            return head == null;
        }
        protected class Node<Item> {
            private Item val;
            private Node<Item> next;
            Node(final Item val, final Node<Item> next) {
                this.val = val;
                this.next = next;
            }
        }
    }
    public void beforeRun(){
        linkedList = new LinkedList<Integer>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(1);
    }
    public void run(){
        
        System.out.println("before");
        linkedList.printList();
        
        linkedList.removeIfDuplicate();
        System.out.println("After");
        linkedList.printList();
    }
    public static void main(String[] args){
        System.out.println("problem: remove duplicate element in linkedlist witout buffers");
        RemoveDuplicateElementWitoutBuffer app = new RemoveDuplicateElementWitoutBuffer();
        app.beforeRun();
        app.run();
    }

}