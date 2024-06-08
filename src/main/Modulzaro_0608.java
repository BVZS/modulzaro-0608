
/* Fajd Balázs */

package main;

import java.util.Random;

public class Modulzaro_0608 {
    
    static Random rnd = new Random();
    
    private static int[] tomb;
    private static final String SEP = System.lineSeparator();
    private static final int alsoErtek = -10;
    private static final int felsoErtek = 10;
    
    public static void main(String[] args) {
        modulzaro();
    }

    private static void modulzaro() {
        programozoiTetelek();
    }
    
    private static void programozoiTetelek() {
        feltolt(9);
        kiir(3);
        
        System.out.println(maxHely());
    }
    
    
    
    
    
    public static int osszegzes() {
        int osszead = 0;
        for (int i = 0; i < tomb.length; i++) {
            osszead += tomb[i];
        }
        return osszead;
    }
    
    private static int megszamlalas() {
        int db = 0;
        for (int i = 0; i < tomb.length; i++) {
            if (tomb[i] == 0) {
                db++;
            }
        }
        return db;
    }
    
    private static int minHely() {
       int minIndex = 0;
        for (int i = 1; i < tomb.length; i++) {
            if(tomb[i] < tomb[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    private static int maxHely() {
       int maxIndex = 0;
        for (int i = 1; i < tomb.length; i++) {
            if(tomb[i] > tomb[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    
    
    
    
    
    private static int velSzam(int also, int felso) {
        return rnd.nextInt((felso - also) + 1) + also;
    }

    private static void feltolt(int db) {
        tomb = new int[db];
        for (int i = 0; i < db; i++) {
            tomb[i] = velSzam(alsoErtek, felsoErtek);
        }
    }
    
    private static void kiir(int oszlop) {
        for (int i = 0; i < tomb.length; i++) {
            System.out.print(tomb[i] + " ");
            if ((i + 1) % oszlop == 0) {
                System.out.println();
            }
        }
    }
    
    
}
