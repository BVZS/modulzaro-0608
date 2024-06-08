
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
        
        osszegzesBemutatasa();
        megszamlalasBemutatasa();
        minHelyBemutatasa();
        maxHelyBemutatasa();
        kivalasztasBemutatasa();
        eldontesEgyBemutatasa();
        eldontesMindBemutatasa();
        linKerMindBemutatasa();
    }
   
    
    
    
    
    
    
    
    
    public static void osszegzesBemutatasa() {
        konzol("[Összegzés]: A tömb elemeinek összegét adja vissza: " + osszegzes() + SEP);
    }
    
    public static void megszamlalasBemutatasa() {
        konzol("[Megszámlálás]: A tömbben lévő nullák számát adja vissza: " + megszamlalas() + SEP);
    }
    
    public static void minHelyBemutatasa() {
        konzol("[Minimum hely]: A tömbben lévő legkisebb érték helyét adja vissza: " + minHely() + SEP);
    }
    
    public static void maxHelyBemutatasa() {
        konzol("[Maximum hely]: A tömbben lévő legnagyobb érték helyét adja vissza: " + maxHely() + SEP);
    }
    
    public static void kivalasztasBemutatasa() {
        konzol("[Kiválasztás]: A tömbben lévő első 5-tel osztható szám helyét adja vissza: " + kivalasztas() + SEP);
    }
    
    public static void eldontesEgyBemutatasa() {
        konzol("[Eldöntés egy]: Megadja, hogy van-e tökéletesz szám a tömbben: " + (eldontesEgy() ? "van" : "nincs") + SEP);
    }
    
    public static void eldontesMindBemutatasa() {
        konzol("[Eldöntés mind]: Megadja, hogy a tömb elemi növekvő sorrendben követik-e egymást: " + (eldontesEgy() ? "igen" : "nem") + SEP);
    }
    
    public static void linKerMindBemutatasa() {
        konzol("[Lineáris keresés]: Ha van a tömbben 13-as érték, megadja a helyét, ha nincs akkor '-1' a visszatérési érték: " + linKer() + SEP);
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
    
    private static int kivalasztas() {
        int i = 0;
        while(!(tomb[i] % 5 == 0)){
            i++;
        }
        return i;  
    }
    
    private static boolean eldontesEgy() {
        boolean vanTokeletes = false;
        for (int i = 0; i < tomb.length; i++) {
            if(tokeletesSzam(tomb[i]) == true) {
                return tokeletesSzam(tomb[i]);
            }
        }
        return vanTokeletes;
    }
    
    public static boolean eldontesMind() {
        for (int i = 1; i < tomb.length; i++) {
            if (tomb[i - 1] > tomb[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static int linKer() {
        for (int i = 0; i < tomb.length; i++) {
            if (tomb[i] == 13) {
                return i;
            }
        }
        return -1;
    }
    
    
    
    
    
    
    
    public static boolean tokeletesSzam(int szam) {
        int osztoOsszeg = 0;
        for (int i = 1; i <= szam / 2; i++) {
            if (szam % i == 0) {
                osztoOsszeg += i;
            }
        }
        return osztoOsszeg == szam;
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
    
    private static void konzol(String szoveg) {
        System.out.print(szoveg);
    }
   
}
