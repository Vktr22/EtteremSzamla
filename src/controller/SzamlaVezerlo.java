
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
        List<AsztalModell> asztalok = new ArrayList<>();
        
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
        

        try {
            Scanner sc = new Scanner(new File(asztalokFileUtvonal));
            String asztalSzinNev = null;
            List<EtelModell> etelekAktualisAsztalhoz = new ArrayList<>();

            while (sc.hasNextLine()) {
                String sor = sc.nextLine().trim();
                if (!sor.isEmpty()) {
                    if (asztalSzinNev == null) {
                        asztalSzinNev = sor;
                    } else {
                        
                        for (EtelModell etel : etelekLista) {
                            if (etel.getEtelNev().equals(sor)) {
                                etelekAktualisAsztalhoz.add(etel);
                                break;
                            }
                        }
                    }
                } else {
                    
                    asztalok.add(new AsztalModell(asztalSzinNev, etelekAktualisAsztalhoz));
                    asztalSzinNev = null;
                    etelekAktualisAsztalhoz = new ArrayList<>();
                }
            }
            
            if (asztalSzinNev != null) {
                asztalok.add(new AsztalModell(asztalSzinNev, etelekAktualisAsztalhoz));
            }   //mivel üres soronként adja hozzá, ha az utsó asztal utsó kaja után nincs új üres sor, akk is adja hozzá az asztal nevét+ételeit
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: asztalok.txt nem található!");
        }

        
       //SzamlaCUInezet.kiir(asztalok);
    }
}
