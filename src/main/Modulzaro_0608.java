
/* Fajd Balázs */

package main;

import java.util.Random;

public class Modulzaro_0608 {
    
    static Random rnd = new Random();
    
    private static int[] tomb;
    private static int[][] tomb2;
    private static final String SEP = System.lineSeparator();
    private static final int alsoErtek = -50;
    private static final int felsoErtek = 50;
    
    public static void main(String[] args) {
        modulzaro();
    }

    private static void modulzaro() {
        programozoiTetelek();
        adatszerkezetTomb();
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
    
    private static void adatszerkezetTomb() {
        tomb2Eloallito(3);
        tomb2kiir(tomb2);
        
        tomb2 = tomb2Invertalo(tomb2);
        tomb2kiir(tomb2);
    }
    
    
    
    
    
    
    
    
    public static int[][] tomb2Eloallito(int meret) {
        tomb2 = new int[meret][meret];
        for (int i = 0; i < meret; i++) {
            for (int j = 0; j < meret; j++) {
                if (i == j) {
                    tomb2[i][j] = velSzam(alsoErtek, felsoErtek);
                } else {
                    tomb2[i][j] = 0;
                }
            }
        }
        return tomb2;
    }
    
    public static void tomb2kiir(int[][] atvettTomb) {
        System.out.print("\t");
        for (int j = 0; j < atvettTomb.length; j++) {
            System.out.print("\u001B[33m" + (j + 1) + "\t");
        }
        System.out.println();
        for (int i = 0; i < atvettTomb.length; i++) {
            System.out.print("\u001B[33m" + (i + 1) + "\t");
            for (int j = 0; j < atvettTomb[i].length; j++) {
                System.out.print("\u001B[0m" + atvettTomb[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static int[][] tomb2Invertalo(int[][] atvettTomb) {
        int[][] ujtomb = atvettTomb;
        for (int i = 0; i < atvettTomb.length; i++) {
            for (int j = 0; j < atvettTomb.length; j++) {
                if (i == j) {
                    ujtomb[i][j] = 0;
                } else {
                    ujtomb[i][j] = (tomb2Min() + tomb2Max()) / 2;
                }
            }
        }
        return ujtomb;
    }
    
    private static int tomb2Min() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tomb2.length; i++) {
            for (int j = 0; j < tomb2[i].length; j++) {
                if (tomb2[i][j] < min) {
                    min = tomb2[i][j];
                }
            }
        }
        return min;
    }
    
    private static int tomb2Max() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tomb2.length; i++) {
            for (int j = 0; j < tomb2[i].length; j++) {
                if (tomb2[i][j] > max) {
                    max = tomb2[i][j];
                }
            }
        }
        return max;
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
        konzol("[Kiválasztás]: A tömbben lévő első 5-tel osztható szám helyét adja vissza (ha nincs, mert véletlenszerű számok vannak a tömbben, akkor '-1'): " + kivalasztas() + SEP);
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
        for (int i = 0; i < tomb.length; i++) {
            if(tomb[i] % 5 == 0) {
                return i;
            }
        } 
        return -1;
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
    
    
    
    
    
    

    public static double mertaniKozep(double min, double max) {
        return Math.sqrt(min * max);
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
