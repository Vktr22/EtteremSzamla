
package nezet;

import modell.AsztalModell;
import modell.EtelModell;
import java.util.List;

public class SzamlaCUInezet {

    public static void kiir(List<AsztalModell> asztalok) {
        for (AsztalModell asztal : asztalok) {
            System.out.println(asztal.getSzin() + " asztal:");
            System.out.println("========================");
            for (EtelModell etel : asztal.getEtelek()) {
                System.out.printf("%-20s %d Ft%n", etel.getEtelNev(), etel.getAr());
            }
            System.out.println("------------------------");
            System.out.println("Összesen: " + asztal.fogyasztasOsszegeAsztalonkent() + " Ft\n");
        }
    }
}
