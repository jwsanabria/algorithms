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
public class Scoreboard {

    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        this.board = new GameEntry[capacity];
    }
    
    
    /** Attempt to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e){
        int newScore = e.getScore();
        // is th new entry e really a high score?
        if(numEntries < board.length || newScore > board[numEntries - 1].getScore()){
            if(numEntries < board.length){
                numEntries++;
            }
            // shift any lower scores rightward to make room for the new entry
            int j = numEntries - 1;
            while(j>0 && board[j-1].getScore()<newScore){
                board[j] = board[j-1];
                j--;
            }
            
            board[j] = e;
        }
    }
    
    public GameEntry remove(int i) throws IndexOutOfBoundsException{
        if(i<0 || i>= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        
        GameEntry temp = board[i];
        for(int j=i; j<numEntries -1; j++){
            board[j] =board[j+1];
        }
        
        board[numEntries-1] = null;
        numEntries--;
        return temp;
    }
    
    
    public static void insertionSort(char[] data){
        int n = data.length;
        for(int k=1; k<n; k++){
            char cur = data[k];
            int j=k;
            while(j>0 && data[j-1] > cur){
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur;
        }
    }
    
    
}
