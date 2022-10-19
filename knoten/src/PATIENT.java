public class PATIENT 
extends BILD
implements DATENELEMENT
{
    private String name;
    private char geschlecht;
    private String leiden;
    private String adresse;
    
    public PATIENT(String nNeu, char gNeu, String lNeu, String aNeu)
    {
        super(900,520, "patient.png");
        this.name = nNeu;
        this.geschlecht = gNeu;
        this.leiden = lNeu;
        this.adresse = aNeu;
    }
    
    public String nenneInfo() {
        return this.name;
    }
}
