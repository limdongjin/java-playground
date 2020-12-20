package org.limdongjin.book_study.ch1;

import java.util.Arrays;

import org.limdongjin.book_study.ch1.Stack;
import org.limdongjin.book_study.ch1.StackImpl;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

class Evaluator {
    Stack<Integer> operandStack;
    Stack<Character> operatorStack;
    List<Character> rawChars;
    
    public Evaluator(String inputString){
        operandStack = new StackImpl();
        operatorStack = new StackImpl();
        rawChars = new ArrayList();
        
        rawChars = inputString.chars()
                   .mapToObj((c) -> (char)c)
                   .collect(Collectors.toList());
    }
    // todo) implement whitelist 
    public static boolean isSkipCh(char ch){
        return ch == '(' || ch == ' ' || ch == '\n';
    }
    public static boolean isOperatorCh(char ch){
        return ch == '+' || ch == '-' || ch == '*';
    }

    public int run(){
        
        // todo) abstraction 
        for(Character ch : rawChars){
            if(isSkipCh(ch)) continue;
            else if(isOperatorCh(ch)) operatorStack.push(ch);
            else if(ch == ')'){
                Character op = this.operatorStack.pop();
                int rightOperand = this.operandStack.pop();
                int leftOperand = this.operandStack.pop();
                if(op == '+'){ // OperatorSet.ADD
                    System.out.printf("%d + %d\n", leftOperand, rightOperand);
                    this.operandStack.push(leftOperand + rightOperand);
                }
                if(op == '*'){//OperatorSet.MUL){
                    System.out.printf("%d * %d\n", leftOperand, rightOperand);
                    this.operandStack.push(leftOperand * rightOperand);
                }
                if(op == '-'){ // == OperatorSet.SUB){
                    System.out.printf("%d - %d\n", leftOperand, rightOperand);
                    this.operandStack.push(leftOperand - rightOperand);
                }
            }else {
                operandStack.push(Integer.parseInt(ch.toString()));
            }
        }

        System.out.println();
        
        return this.operandStack.peek();
    }
    public static void main(String[] args){
        //Stack<Integer> stack = new StackImpl();
        System.out.println("( 1+( (2+3)*(4*5)))");
        Evaluator evaluator = new Evaluator("( 1+( (2+3)*(4*5)))");
        System.out.println(evaluator.run());
    } 

    public enum OperatorSet {
        ADD, 
        MUL, 
        SUB
    }
}