package org.limdongjin.book_study.ch1;
import org.limdongjin.book_study.ch1.StackImpl;
import org.limdongjin.book_study.ch1.Stack;

class StackTest {
    public static void main(String[] args){
        Stack<Integer> stack = new StackImpl();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("push 1");
        System.out.println("push 2");
        System.out.println("push 3");

        System.out.printf("Peek: %d\n" , stack.peek());
        
        System.out.printf("Pop %d\n", stack.pop());
        System.out.printf("Peek: %d\n", stack.peek());
        for(int num : stack)
            System.out.printf("%d ", num);
        System.out.println();
        System.out.printf("Pop %d\n", stack.pop());
        System.out.printf("Pop %d\n", stack.pop());
        for(int num : stack)
            System.out.printf("%d ", num);
        stack.push(5);
        System.out.println("push 5");
        for(int num : stack)
            System.out.printf("%d ", num);
        System.out.println();
    }
}