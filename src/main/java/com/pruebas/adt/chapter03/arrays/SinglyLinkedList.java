/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebas.adt.chapter03.arrays;

/**
 *
 * @author William
 */
public class SinglyLinkedList<E> {
    // ----------- nested Node class -------------
    private static class Node<E>{
        private E element;      // reference to the element stored at this node
        private Node<E> next;   // reference to the subsequent node in te list
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }
    
    //---------- end of nested Node class --------------
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size==0)
            tail = head;
        size++;
    }
    
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()){
            head = newest;
        }else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }
    
    public E removeFirst(){
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
            tail = null;
        return answer;
    }
    
    public static void main(String[] args) {
        SinglyLinkedList<String> lista = new SinglyLinkedList<String>();
        lista.addFirst("LAX");
        lista.addLast("MSP");
        lista.addLast("ATL");
        lista.addLast("BOS");
        
        while(!lista.isEmpty()){
            System.out.print(lista.removeFirst());
            System.out.print(" -> ");
        }
        
    }
}
