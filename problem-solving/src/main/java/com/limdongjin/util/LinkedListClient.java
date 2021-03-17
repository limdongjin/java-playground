package com.limdongjin.util;

class LinkedListClient {
    LinkedList<Integer> linkedList;
    public LinkedListClient(){
        linkedList = new LinkedList<>();
    }
    public void run(){
        test_justprint();
        test_data();
    }
    /* 
     * @pre linkedList.size() == 1 
    */
    public void test_data(){
        linkedList.add(1);
        // assert linkedList.peek() == 1;
    }
    private void test_justprint(){
        System.out.println("run!");
        linkedList.add(1);
        p();
        System.out.println("get(0)=" + linkedList.get(0));
        linkedList.addFirst(4);
        linkedList.remove();
        p();
        linkedList.add(2);
        p();
        System.out.println("get(0)=" +linkedList.get(0));
        System.out.println("get(1)=" +linkedList.get(1));
        linkedList.add(411);
        linkedList.remove();
        p();
        linkedList.add(13);
        p();
        System.out.println("find(200)="+ linkedList.find(200));
        System.out.println("find(4)="+ linkedList.find(4));
        System.out.println("find(2)="+ linkedList.find(2));
        System.out.println("find(13)="+ linkedList.find(13));
        p();
        System.out.println("get(0)=" +linkedList.get(0));
        System.out.println("get(1)=" +linkedList.get(1));
        System.out.println("get(2)=" +linkedList.get(2));
        
        linkedList.remove();
        linkedList.addFirst(10);
        linkedList.addFirst(1111);
        p(); 

        linkedList = null;
        linkedList = new LinkedList<>();
    }
    private void p(){
        for(var l : linkedList) 
            System.out.printf("%d ", l);
        System.out.println();
    }
    public static void main(String[] args){
        LinkedListClient app = new LinkedListClient();
        app.run();
    }
} 