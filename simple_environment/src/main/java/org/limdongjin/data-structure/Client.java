package org.limdongjin.data_structure;

import org.limdongjin.data_structure.FixedCapacityStackOfString;
import org.limdongjin.data_structure.Queue;
import org.limdongjin.data_structure.QueueImpl;

class Client {
    Queue<String> queue;
    FixedCapacityStackOfString stack;
    public Client(){
        queue = new QueueImpl();
        stack = new FixedCapacityStackOfString(10);
    }
    public void run(){
        stack_test();
        System.out.println("queue start");
        queue_test();
    }
    private void queue_test(){
        queue.enqueue("Hello");
        System.out.println("enqueue ok");
        queue.enqueue("world");
        System.out.println("enqueue ok");
        for(var q : queue)
            System.out.println(q);
    }
    private void stack_test(){
        stack.push("hello");
        stack.push("world");
        stack.push("good");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push("inter");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
    public static void main(String[] args){
        Client app = new Client();
        app.run();
    }
}