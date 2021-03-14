/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author User
 */
public class Stack<T> {
    ListNode head;
    
    public Stack() {
        head=null;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public void push(T a){
        head=new ListNode(a,head);
    }
    
    public T pop(){
        if(head==null)
            return null;
        T temp=(T) head.getData();
        head=head.getLink();
        return temp;
    }
    
    public T peek(){
        return (T) head.getData();
    }
    
    public void showStack(){
        if(head==null)
            System.out.println("Empty");
        else{
            ListNode currentNode=head;
            while(currentNode!=null){
                System.out.print(currentNode);
                currentNode=currentNode.getLink();
            }
        }
    }
    
    public int getSize(){
        int count=0;
        if(isEmpty())
            return count;
        else
        {
            ListNode currentNode=head;
            while(currentNode!=null){
                count++;
                currentNode=currentNode.getLink();
            }
        }
        return count;
    }
}
