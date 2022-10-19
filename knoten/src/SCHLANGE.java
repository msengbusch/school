public class SCHLANGE
{
    private DATENELEMENT[] schlange; // Erzeuge ein neues Arrayobjekt vom angegebenen Datentyp.
    private int anzahlMax;
    private int anzahlAktuell;

    public SCHLANGE(int laenge)
    {
        this.anzahlMax = laenge;
        this.anzahlAktuell = 0;   
        
        // Das Arrayobjekt wird mit dem Typ AUFLISTBAR initialisiert 
        this.schlange = new DATENELEMENT[laenge];
        
        // Ab jetzt wird ausschliesslich mit dem angegebenen Datentyp (bzw. natuerlich dessen Platzhalter T) gearbeitet.
    }

    public boolean hintenEinreihen(DATENELEMENT t)
    {
        if (!this.istVoll()) 
        {
            this.schlange[this.anzahlAktuell] = t;
            this.anzahlAktuell = this.anzahlAktuell + 1;
            return true;
        }
        else 
        {
            return false;
        }
    }

    public DATENELEMENT vorneEntnehmen() 
    {
        if (!this.istLeer()) 
        {
            DATENELEMENT t = this.schlange[0];
            for(int i = 0; i < this.anzahlAktuell - 1; i++)
            {
                this.schlange[i] = this.schlange[i + 1];
            }
            this.anzahlAktuell = this.anzahlAktuell - 1;
            return t;
        }
        else 
        {
            return null;
        }
    }
    
    public boolean istLeer() 
    {
        if (this.anzahlAktuell == 0) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public boolean istVoll() 
    {
        return (this.anzahlAktuell == this.anzahlMax);
    }

    public int nenneAnzahlAktuell() 
    {
        return this.anzahlAktuell;
    }
    
    public void alleAusgeben()
    {
        for(int i = 0; i<anzahlAktuell;i++)
        {
            schlange[i].nenneInfo();
        }
    }
}
