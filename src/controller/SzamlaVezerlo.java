
package controller;

import modell.EtelModell;
import modell.AsztalModell;
//import nezet.SzamlaCUInezet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SzamlaVezerlo {

    public static void main(String[] args) {
        List<EtelModell> etelekLista = new ArrayList<>();
        String etelekFileUtvonal = "src/etelek.txt";
        String asztalokFileUtvonal = "src/asztalok.txt";

      
        try {
            Scanner sc = new Scanner(new File(etelekFileUtvonal));
            while (sc.hasNextLine()) {
                String sor = sc.nextLine();
                String[] egySorReszekreBontva = sor.split("\\|");
                String etelNeve = egySorReszekreBontva[0];
                int ar = Integer.parseInt(egySorReszekreBontva[1]);
                etelekLista.add(new EtelModell(etelNeve, ar));
            }
            
            sc.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Hiba:a fájl nem található!");
        }
        
        
    }
}
