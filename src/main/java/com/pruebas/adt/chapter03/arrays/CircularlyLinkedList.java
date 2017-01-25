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
public class CircularlyLinkedList<E> {
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
    
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public E first(){
        if(isEmpty()) return null;
        return tail.getNext().getElement();
    }
    
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    
    public void rotate(){
        if(tail!=null){
            tail = tail.getNext();
        }
    }
    
    public void addFirst(E e){
        if(size==0){
            tail = new Node<>(e, null);
            tail.setNext(tail);
        }else{
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    
    public void addLast(E e){
        addFirst(e);
        tail=tail.getNext();
    }
    
    public E removeFirst(){
        if(isEmpty()) return null;
        Node<E> head = tail.getNext();
        if(head== tail) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getElement();
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
