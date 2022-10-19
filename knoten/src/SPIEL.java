import ea.*;
import ea.edu.*;

/**
 * Die Klasse SPIEL ist ein Template, das so wie es ist an Schueler ausgegeben werden kann.
 * (Einzige Voraussetzung ist, dass die engine-alpha-Bibliothek im Suchpfad erreichbar ist.)
 * Es startet alles Notwendige fuer ein Spiel.
 * 
 * Beim Konstruktor ohne Parameter gibt es keine Punkte-Anzeigen und auch keine Maus-Interaktion.
 * Die Methoden tick() und tasteReagieren() werden immer automatisch aufgerufen.
 * 
 * Beim Konstruktor mit Parametern koennen die linken und rechten Punkte-Anzeigen sowie die 
 * Interaktion mit der Maus ein- bzw. ausgeschaltet werden.
 * 
 * @author Michael Andonie und Mike Ganshorn  (nach Idee von Bendikt Lindemann)
 * 
 * @version     2.3 (2017-04-11)
 * 
 * @changelog   2.3 Ticker startet NICHT mehr automatisch !!!
 *                  Methoden-Signaturen "geglaettet"
 *                  neue Konstruktoren
 *                  Methode tasteGedrueckt( int taste )
 * 
 */
public class SPIEL 
{
    /**
     * Die Anzeige des Spiels.
     */
    private static AnzeigeE anzeige;
    //public static AnimationsManager animationsManager;
    
    /**
     * Dieser Zaehler ermoeglicht den Tik-Tak-Wechsel.
     */
    private int zaehler;
    
    
    
    /**
     * Erstellt ein einfaches Spiel: Breite 800 , Hoehe 600 , ohne Punktestand und Maus. <br /> 
     * Ueberschreibe bei Bedarf die Methoden tick() bzw. tasteReagieren(int taste).
     */
    public SPIEL() 
    {
        this( 800 , 600 , false , false , false );
    }

    
    
    /**
     * Erstellt ein einfaches Spiel ohne Punktestand und Maus. <br /> 
     * Ueberschreibe bei Bedarf die Methoden tick() bzw. tasteReagieren(int taste).
     * 
     * @param   breite      Breite des Spielfelds in Pixel
     * 
     * @param   hoehe       Hoehe des Spielfelds in Pixel
     */
    public SPIEL( int breite , int hoehe ) 
    {
        this( breite , hoehe , false , false , false );
    }
    
    
    
    /**
     * Erstellt ein einfaches Spiel ohne Punktestand aber mit Maus. <br /> 
     * Ueberschreibe bei Bedarf die Methoden tick() bzw. tasteReagieren(int taste).
     * 
     * @param   breite      Breite des Spielfelds in Pixel
     * 
     * @param   hoehe       Hoehe des Spielfelds in Pixel
     * 
     * @param   maus        true, wenn ein Mauszeiger angezeigt werden soll, sonst false
     */
    public SPIEL( int breite , int hoehe , boolean maus ) 
    {
        this( breite , hoehe , false , false , maus );
    }
    
    
    
    /**
     * Erstellt ein einfaches Spiel mit 2 Punkteanzeigen und mit Maus. <br /> 
     * Ueberschreibe bei Bedarf die Methoden tick() bzw. tasteReagieren(int taste).
     * 
     * @param   breite          Breite des Fensters in Pixel
     * 
     * @param   hoehe           Hoehe des Fensters in Pixel
     * 
     * @param   punkteLinks     true  : man sieht links eine Punkteanzeige 
     *                          false : man sieht sie nicht
     *                          
     * @param   punkteRechts    true  : man sieht rechts eine Punkteanzeige 
     *                          false : man sieht sie nicht
     *                          
     * @param   maus            true  : man sieht den Mauszeiger  (Klick-Spiel) 
     *                          false : man sieht ihn nicht       (reines Tastatur-Spiel)
     */
    public SPIEL( int breite , int hoehe , boolean punkteLinks , boolean punkteRechts , boolean maus ) 
    {
        //Zaehler fuer Tick, Tack, ...
        zaehler = 0;
        anzeige = new AnzeigeE( breite , hoehe );
        //animationsManager = AnimationsManager.getAnimationsManager();
        
        //Punkteanzeige
        anzeige.punkteLinksSichtbarSetzen( punkteLinks );
        anzeige.punkteRechtsSichtbarSetzen( punkteRechts );
        
        //Maus ggf. aktivieren
        if ( maus ) 
        {
            anzeige.klickReagierbarAnmelden( this , true );
        }
        
        //Tastatur
        anzeige.tastenReagierbarAnmelden( this );
        
        //Ticker
        //Alle 500 Millisekunden (=Jede halbe Sekunde) ein Tick
        //anzeige.tickerAnmelden(this, 500); 
    }
    
    
    
    /**
     * Wird regelmaessig automatisch aufgerufen. So kommt Bewegung ins Spiel! 
     * Tick-Intervall kann angepasst werden. Ticker muss erst gestartet werden.
     */
    public void tick() 
    {
        //Einfache Bildschirmausgabe. Kann spaeter in Subklasse beliebig ueberschreiben werden.
        zaehler++;
        zaehler = zaehler % 2;
        if ( zaehler == 1 ) 
        {
            System.out.println( "Tick!" );
        }
        else 
        {
            System.out.println( "Tack!" );
        }
    }
    
    

    /**
     * Wird bei jedem Mausklick (Linksklick) automatisch aufgerufen.
     * 
     * @param   x   Die X-Koordinate des Klicks
     * 
     * @param   y   Die Y-Koordinate des Klicks
     */
    public void klickReagieren( int x , int y ) 
    {
        //Einfache Bildschirmausgabe. Kann spaeter in Subklasse beliebig ueberschrieben werden.
        System.out.println( "Klick bei (" + x  + ", " + y + ")." );
    }
    
    
    
    /**
     * Wird bei jedem Tastendruck automatisch aufgerufen und automatisch das Kuerzel der entsprechenden Taste mitgegeben.
     * 
     * @param   taste   ganzzahliges Kuerzel der Taste (Farben_Tastencode.pdf) 
     *                  oder ENUM-Typ aus Klasse TASTE (darin die Klassen-Doku lesen)
     */
    public void tasteReagieren( int taste ) 
    {
        System.out.println( "Taste mit Kuerzel " + taste + " wurde gedrueckt" );
    }
    
    
    
    /**
     * Setzt das Ticker-Intervall.
     * 
     * @param   ms  Die Zeit in Millisekunden zwischen zwei
     *              Aufrufen der <code>tick()</code>-Methode.
     */
    public void tickerIntervallSetzen( int ms ) 
    {
        anzeige.tickerAbmelden( this );
        anzeige.tickerAnmelden( this , ms );
    }
    
    
    /**
     * Stoppt die Ticker-Funktion. Die <code>tick()</code>-Methode
     * wird nicht weiter aufgerufen. Der automatische Aufruf der 
     * <code>tick()</code>-Methode kann durch die Methode 
     * <code>tickerNeuStarten(int ms)</code> wiedergestartet werden.
     * 
     * @see     #tickerNeuStarten(int)
     */
    public void tickerStoppen() 
    {
        anzeige.tickerAbmelden( this );
    }
    
    
    /**
     * Startet den Ticker neu.
     * 
     * @param   ms      Die Zeit in Millisekunden zwischen zwei
     *                  Aufrufen der <code>tick()</code>-Methode. 
     */
    public void tickerNeuStarten( int ms ) 
    {
        anzeige.tickerAbmelden( this );
        anzeige.tickerAnmelden( this , ms );
    }
    
    
    /**
     * Setzt ein neues Maus-Icon.
     * 
     * @param   pfad        Der Pfad zu dem Bild (jpg, bmp, png), das 
     *                      das neue Maus-Icon werden soll. ZB: "mausicon.png"
     *                      
     * @param   hotspotX    Die X-Koordinate des Hotspots fuer das neue
     *                      Maus-Icon. (relativ im Icon)
     *                      
     * @param   hotspotY    Die Y-Koordinate des Hotspots fuer das neue
     *                      Maus-Icon. (relativ im Icon)
     */
    public void setzeMausIcon( String pfad , int hotspotX , int hotspotY ) 
    {
        ea.edu.FensterE.getFenster().mausAnmelden( new Maus( new Bild(0,0,pfad) , new Punkt(hotspotX,hotspotY) ) , true );
    }
    
    
    /**
     * Sorgt dafuer, dass sowohl der rechte als auch der linke Punktestand sichtbar ist.
     */
    public void setzeAllePunkteanzeigenSichtbar() 
    {
        anzeige.punkteLinksSichtbarSetzen( true );
        anzeige.punkteRechtsSichtbarSetzen( true );
    }
    
    
    /**
     * Sorgt dafuer, dass nur der linke Punktestand sichtbar ist.
     */
    public void setzeNurRechtePunkteanzeigeSichtbar() 
    {
        anzeige.punkteLinksSichtbarSetzen( false );
        anzeige.punkteRechtsSichtbarSetzen( true );
    }
    
    
    /**
     * Sorgt dafuer, dass nur der rechte Punktestand sichtbar ist.
     */
    public void setzeNurLinkePunkteanzeigeSichtbar() 
    {
        anzeige.punkteLinksSichtbarSetzen( true );
        anzeige.punkteRechtsSichtbarSetzen( false );
    }
    
    
    /**
     * Sorgt dafuer, dass weder der rechte noch der linke Punktestand sichtbar ist.
     */
    public void setzeAllePunkteanzeigenUnsichtbar() 
    {
        anzeige.punkteLinksSichtbarSetzen( false );
        anzeige.punkteRechtsSichtbarSetzen( false );
    }
    
    
    /**
     * Setzt den linken Punktestand. Aenderungen sind nur sichtbar,
     * wenn auch der linke Punktestand sichtbar ist.
     * 
     * @param   neuerPunktestand      Der neue linke Punktestand.
     */
    public void setzePunkteanzeigeLinks( int neuerPunktestand ) 
    {
        anzeige.punkteLinksSetzen( neuerPunktestand );
    }
    
    
    /**
     * Setzt den rechten Punktestand. Aenderungen sind nur sichtbar,
     * wenn auch der rechte Punktestand sichtbar ist.
     * 
     * @param   neuerPunktestand      Der neue rechte Punktestand.
     */
    public void setzePunkteanzeigeRechts( int neuerPunktestand ) 
    {
        anzeige.punkteRechtsSetzen( neuerPunktestand );
    }


    /**
     * Aendert die Farbe der Punktestandsanzeige
     *
     * @param farbe     Die neue Farbe der Puntkestandsanzeige
     */
    public void setzePunkteanzeigeFarbe( String farbe ) 
    { 
        anzeige.setzeFarbePunktestand( farbe ); 
    }
    
     
    /**
     * Gibt eine Zufallszahl aus.
     * 
     * @param von   Die Untergrenze der Zufallszahl (INKLUSIVE)
     * 
     * @param bis   Die Obergrenze der Zufallszahl (INKLUSIVE)
     * 
     * @return      Eine Zufallszahl z mit:   von <= z <= bis
     */
    public int zufallszahlVonBis( int von , int bis ) 
    {
        return anzeige.zufallszahlVonBis( von , bis );
    }
    
    
    /**
     * Setzt eine Hintergrundgrafik fuer das Spiel. Dieses Bild liegt immer hinter allen anderen Objekten. 
     * 
     * @param   pfad    Der Pfad der Bilddatei (jpg, bmp, png) des Bildes,
     *                  das benutzt werden soll. ZB: "hintergrund.jpg"
     */
    public void setzeHintergrundgrafik( String pfad ) 
    {
        ea.edu.FensterE.getFenster().hintergrundSetzen( new Bild(0,0,pfad) );
    }
    
    
    /**
     * Wartet um die Angegebene Anzahl an Millisekunden bis zur Ausfuehrung des naechsten Befehls. 
     * !!! VORSICHT !!! Innerhlab der Methode tick()  N I C H T  verwenden !!!
     *
     * @param   ms  Die zu wartende Zeit in Millisekunden
     */
    public void warte( int ms )
    {
        try
        {
            Thread.sleep( ms );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Ueberprueft, ob eine Taste gerade gedrueckt gehalten wird.
     * 
     * @param   taste   Der ganzzahlige Wert, der fuer die gedrueckte Taste steht.
     *                  Details koennen in der <i>Tabelle aller Tastaturkuerzel</i> abgelesen werden. 
     *                  Oder man verwendet die ENUM-Typen der Klasse TASTE (Klassen-Doku lesen).
     *                  
     * @return  true, falls die Taste gedrueckt gehalten wird.                 
     */
    public boolean tasteGedrueckt( int taste )
    {
        return FensterE.getFenster().tasteGedrueckt( taste );
    }
}
