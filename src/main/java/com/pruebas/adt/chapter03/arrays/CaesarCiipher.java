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
public class CaesarCiipher {
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    /** Constructor that initializes the encryption an decryption arrays */
    public CaesarCiipher(int rotation) {
        for(int k=0; k<26; k++){
            encoder[k] = (char) ('A' + (k+rotation)%26);
            decoder[k] = (char) ('A' + (k-rotation+26)%26);
        }
    }
    
    /** Returns String representing encrypted message */
    public String encrypt(String message){
        return transform(message, encoder);
    }
    
    /** Returns decrypted message given encrypted secret */
    public String decrypt(String message){
        return transform(message, decoder);
    }
    
    /** Returns transformation of original String using given code */
    public String transform(String orignal, char[] code){
        char[] msg = orignal.toCharArray();
        for(int k=0; k<msg.length; k++){
            if(Character.isUpperCase(msg[k])){
                int j = msg[k] - 'A';
                msg[k] = code[j];
            }
        }
        return new String(msg);
    }
    
    public static void main(String[] args) {
        CaesarCiipher cipher = new CaesarCiipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " +   coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
        
    }
}
