package org.limdongjin.LinkedList;

//import simple_environment.src.ch2_linked_list2.LinkedList.LinkedList;
//import LinkedList.LinkedList;
//import LinkedList.LinkedList;
import org.limdongjin.LinkedList.LinkedList;
class TestLinkedList {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        
        linkedList.append(10);
        
        assert (int)linkedList.get(0) == 10;
        assert linkedList.size() == 1;
        
        System.out.println("test clear");
    }
}