
public class KNOTEN {
    
    private DATENELEMENT inhalt;
    private KNOTEN nachfolger;
    
    public KNOTEN(DATENELEMENT inhaltNeu) {
        inhalt = inhaltNeu;
    }
    
    public KNOTEN nenneNachfolger() {
        return nachfolger;
    }
    
    public void setzeNachfolger(KNOTEN k) {
        nachfolger = k;
    }
    
    public DATENELEMENT nenneInhalt(){
        return inhalt;
    }
    
    public void setzeInhalt(DATENELEMENT i) {
        inhalt = i;
    }
    
    
}
