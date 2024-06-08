/* Fajd Balázs */

package main;

import java.util.Scanner;

public class LogikaiJatek {

    static Scanner sc = new Scanner(System.in);
    
    private static final String SEP = System.lineSeparator();
    private static int[] palya = new int[7];
    private static boolean jatekFut = true;
    
    public static void main(String[] args) {
        logikaiJatek();
    }

    private static void logikaiJatek() {
        palyaAlapertelmezes();
        palyaMutat();
        lepes();
    }

    private static void lepes() {
        String valasz = "";
        while(jatekFut) {
            konzol("Mit lépsz? \n[x | o] ");
            valasz = sc.nextLine();

            if(valasz.equals("x")) {
                lepesValasztva(1);
            }
            else if(valasz.equals("o")) {
                lepesValasztva(2);
            } 
            else if(valasz.equals("r")) {
                jatekReset();
            } 
            else {
                valasz = sc.nextLine(); 
            }
        }
    }
    
    
    
    
    private static void lepesValasztva(int lepes) {
        int lepesIndex;
        boolean lepett = false;
        
        if(lepes == 1) {
            for (int i = 0; i < palya.length; i++) {
                if(palya[i] == 1) {
                    if(palya[i + 1] == 0) { // szimpla lépés
                        palya[i] = 0;
                        palya[i + 1] = 1;
                        lepett = true;
                        break;
                    }
                    else if(palya[i + 1] == 2 && palya[i + 2] == 0) { // átugrás
                        palya[i] = 0;
                        palya[i + 2] = 1;
                        lepett = true;
                        break;
                    }
                }
            }
        }
        else if(lepes == 2) {
            for (int i = 0; i < palya.length; i++) {
                if(palya[i] == 2) {
                    if(palya[i - 1] == 0) {
                        palya[i] = 0;
                        palya[i - 1] = 2;
                        lepett = true;
                        break;
                    }
                    else if(palya[i - 1] == 1 && palya[i - 2] == 0) { // átugrás
                        palya[i] = 0;
                        palya[i - 2] = 2;
                        lepett = true;
                        break;
                    }
                }
            }
        }
        palyaMutat();
        jatekEredmeny();
    }
    
    private static void jatekEredmeny() {
        if(palya[0] == 2 && palya[1] == 2 && palya[2] == 2 && palya[3] == 0 && palya[4] == 1 && palya[5] == 1 && palya[6] == 1) {
            konzol("\u001B[32mNyertél, vége a játéknak!");
            jatekFut = false;
        }
    }
    
    private static void jatekReset() {
        palyaAlapertelmezes();
        palyaMutat();
    }
   
    
    
    
    
    private static void palyaMutat() {
        konzol("\u001B[33m");
        for (int i = 0; i < palya.length; i++) {
            if(palya[i] == 0) konzol("_ ");
            else if(palya[i] == 1) konzol("X ");
            else if(palya[i] == 2) konzol("O ");
        }
        konzol("\u001B[0m" + SEP);
    }

    private static void palyaAlapertelmezes() {
        palya[0] = 1;
        palya[1] = 1;
        palya[2] = 1;
        palya[3] = 0;
        palya[4] = 2;
        palya[5] = 2;
        palya[6] = 2;
    }
    
    private static void konzol(String szoveg) {
        System.out.print(szoveg);
    }
}
