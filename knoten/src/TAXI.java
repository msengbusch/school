public class TAXI 
extends BILD
implements DATENELEMENT
{
    private String kfz;
    
    public TAXI(String kfz)
    {
        super(900, 520, "taxi.png");
        this.kfz = kfz;
    }
    
    public String nenneInfo() {
        return this.kfz;
    }
}
