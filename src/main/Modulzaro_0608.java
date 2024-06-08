
/* Fajd Balázs */

package main;

import java.util.Random;

public class Modulzaro_0608 {
    
    static Random rnd = new Random();
    
    private static int[] tomb;
    private static final String SEP = System.lineSeparator();
    private static final int alsoErtek = 1;
    private static final int felsoErtek = 30;
    
    public static void main(String[] args) {
        modulzaro();
    }

    private static void modulzaro() {
        programozoiTetelek();
    }
    
    private static void programozoiTetelek() {
        feltolt(10);
        kiir(3);
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
