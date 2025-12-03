
package modell;


public class EtelModell {
    private String etelNev;
    private int ar;
    
    public EtelModell(String etelNev){
        this.etelNev = etelNev;
    }
    
    public EtelModell(String etelNev, int ar){
        this.etelNev = etelNev;
        this.ar = ar;
    }

    public String getEtelNev() {
        return etelNev;
    }

    public int getAr() {
        return ar;
    }
    
}
