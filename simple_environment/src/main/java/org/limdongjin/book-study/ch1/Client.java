package org.limdongjin.book_study.ch1;

import org.limdongjin.book_study.ch1.FixedCapacityStackOfString;

class Client {
    public static void main(String[] args){
        FixedCapacityStackOfString stack = new FixedCapacityStackOfString(10);
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
}