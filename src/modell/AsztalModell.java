
package modell;

import java.util.List;


public class AsztalModell {
    private String szin;
    private List<EtelModell> etelek;

    public AsztalModell(String szin, List<EtelModell> etelek) {
        this.szin = szin;
        this.etelek = etelek;
    }

    public String getSzin() {
        return szin;
    }

    
    public List<EtelModell> getEtelek() {
            return etelek;
    }
    
    
    public int fogyasztasOsszegeAsztalonkent(){
        
        int osszeg = 0;
        
        for (EtelModell e : etelek) {
            osszeg += e.getAr();
        }
        return osszeg;


    }
}
