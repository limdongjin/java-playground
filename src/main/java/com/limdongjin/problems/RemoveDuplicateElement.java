package com.limdongjin.problems;

import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicateElement {
    private final LinkedList<Integer> linkedList;

    protected class LinkedList<E> implements Iterable<E> {
        private Node head;
        private Node tail;
        private int n = 0;

        public void addFirst(final E item) {
            final Node node = new Node(item, null);

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
            final HashSet<E> set = new HashSet<>();
            Node cur = head;
            set.add((E) cur.val);
            while (cur.next != null) {
                if (!set.contains(cur.next.val)) {
                    set.add(cur.next.val);
                    cur = cur.next;
                    continue;
                }
                cur.next = cur.next.next;
            }
        }

        public Iterator<E> iterator() {
            return new Iterator<E>() {
                Node cur = head;

                @Override
                public boolean hasNext() {
                    return cur != null;
                }

                @Override
                public E next() {
                    final E nextVal = cur.val;
                    cur = cur.next;
                    return nextVal;
                }
            };
        }

        protected class Node {
            protected E val;
            protected Node next;

            public Node(final E val, final Node next) {
                this.val = val;
                this.next = next;
            }
        }
    }

    public RemoveDuplicateElement() {
        linkedList = new LinkedList<Integer>();
    }

    private void before_run() {

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(3);
        linkedList.addFirst(1);
        linkedList.addFirst(111);
        linkedList.addFirst(3);
        linkedList.addFirst(1);
    }

    private void run() {
        before_run();

        System.out.println("Before");
        for (final var val : linkedList)
            System.out.println(val);

        System.out.println("Afrer");
        linkedList.removeIfDuplicate();
        for (final var val : linkedList)
            System.out.println(val);
    }

    public static void main(final String[] args) {
        System.out.println("*problem: remove duplicated element from linkedlist*");
        final RemoveDuplicateElement app = new RemoveDuplicateElement();
        app.run();

    }
}
