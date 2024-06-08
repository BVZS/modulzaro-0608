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
            konzol("Mit lépsz? (x, o) ");
            valasz = sc.nextLine();

            if(valasz.equals("x")) {
                System.out.println("x-et lépsz");
                lepesValasztva(1);
            }
            else if(valasz.equals("o")) {
                System.out.println("o-et lépsz");
                lepesValasztva(2);
            } 
            else {
               System.out.print("Hibás válasz. (x, o) ");
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
                    if(palya[i + 1] == 0) {
                        palya[i] = 0;
                        palya[i + 1] = 1;
                        lepett = true;
                    }
                }
            }
        }
        else if(lepes == 2) {
            for (int i = palya.length; i > 0; i--) {
                if(palya[i] == 2) {
                    if(palya[i - 1] == 0) {
                        palya[i] = 0;
                        palya[i - 1] = 2;
                        lepett = true;
                    }
                }
            }
        }
        
        
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
