import ea.edu.*;
import ea.*;

/**
 * Klasse TEXT zum Darstellen von Texten in EDU-Engine
 * 
 * @author      mike ganshorn
 * 
 * @version     1.3-beginner (2017-04-11)
 *                  Methode:    setzeGroesse(...)
 *                              setzeFarbe(...)
 * 
 * @changelog   1.3 WECHSELBILD erbt von Knoten und damit von Raum
 *                  verschiebenUm greift auf bewegen zurueck
 *                  Methoden in allen Klassen vereinheitlicht (bis auf indiv. Methoden)
 *                  setzeInhalt(int) hinzugefuegt (bisher nur String)
 *                  Konstruktor(int,int,int) hinzugefuegt (bisher nur int,int,String)
 * 
 *              1.2 Methode beruehrt(WECHSELBILD) hinzugefuegt
 * 
 *              1.1 Jump'n'Run-Physik hinzu gefuegt
 *              
 */
public class TEXT
extends TextE 
{
    
    
    /**
     * TEXT Konstruktor
     *
     * @param   x       x-Koordinate im Fenster (Pixel)
     * 
     * @param   y       y-Koordinate im Fenster (Pixel)
     * 
     * @param   text    anzuzeigender Text
     */
    public TEXT( int x , int y , String text ) 
    {
        super( text );
        super.mittelpunktSetzen( x , y );
    }
    
    
    /**
     * TEXT Konstruktor
     *
     * @param   x       x-Koordinate im Fenster (Pixel)
     * 
     * @param   y       y-Koordinate im Fenster (Pixel)
     * 
     * @param   zahl    anzuzeigende Zahl
     */
    public TEXT(int x, int y, int zahl) 
    {
        super(""+zahl);
        super.mittelpunktSetzen(x, y);
    }
    
    
    /**
     * Setzt den angezeigten Text neu.
     *
     * @param   text    Der neue Text
     */
    public void setzeInhalt( String text )
    {
        super.setzeInhalt(text);
    }
    
    
    /**
     * Setzt den angezeigten Text neu.
     *
     * @param   text    Der neue Text
     */
    public void setzeInhalt( int zahl )
    {
        super.setzeInhalt( "" + zahl );
    }
    
    
    /**
     * Setzt die Schriftgroesse auf einen neuen Wert.
     *
     * @param   schriftgroesse  neue Schriftgroesse
     */
    public void setzeGroesse( int schriftgroesse )
    {
        super.setzeGroesse( schriftgroesse );
    }
    
    
    /**
     * Setzt die Schriftfarbe neu.
     *
     * @param   schriftfarbe    Die neue Schriftfarbe
     */
    public void setzeFarbe( String schriftfarbe )
    {
        super.setzeFarbe( schriftfarbe );
    }
    
    
    /**
     * Verschiebt das Objekt um die angegebenen Pixel. 
     *
     * @param   deltaX  Pixel in x-Richtung (wird bei Bedarf auf ganze Pixel gerundet)
     * 
     * @param   deltaY  Pixel in y-Richtung (wird bei Bedarf auf ganze Pixel gerundet)
     */
    public void verschiebenUm( float deltaX , float deltaY ) 
    {
        super.bewegen( deltaX , deltaY );
    }
    
    
    /**
     * Prueft, ob ein anderes Grafik-Objekt beruehrt wird. 
     *
     * @param   r   Ein anderes BILD, RECHTECK, KREIS, DREIECK, ...
     * 
     * @return  true, wenn sich die beiden Objekte ueberschneiden
     */
    public boolean beruehrt( Raum r ) 
    {
        return super.schneidet( r );
    }

    
    /**
     * Prueft, ob das Objekt einen bestimmten Punkt (in Pixel-Koordinaten) beinhaltet. 
     *
     * @param   x   x-Koordinate des Punkts (Pixel)
     * 
     * @param   y   x-Koordinate des Punkts (Pixel)
     * 
     * @return      true, wenn Punkt innerhalb der Grafik
     */
    public boolean beinhaltetPunkt( int x , int y ) 
    {
        return super.beinhaltet( new Punkt(x,y) );
    }
    
    
    /**
     * Setzt den Mittelpunkt des Objekts auf einen (in Pixel-Koordinaten) anzugebenden Punkt. 
     *
     * @param   x   x-Koordinate des Mittelpunkts (Pixel)
     * 
     * @param   y   y-Koordinate des Mittelpunkts (Pixel)
     */
    public void setzeMittelpunkt( int x , int y ) 
    {
        super.mittelpunktSetzen( x , y );
    }
    
    
    /**
     * Nennt die x-Koordinate (in Pixel) des Mittelpunkts dieses Objekts. 
     *
     * @return  x-Koordinate des Mittelpunkts (Pixel)
     */
    public int nenneMx() 
    {
        return super.zentrum().x();
    }
    
    
    /**
     * Nennt die y-Koordinate (in Pixel) des Mittelpunkts dieses Objekts. 
     *
     * @return  y-Koordinate des Mittelpunkts (Pixel)
     */
    public int nenneMy() 
    {
        return super.zentrum().y();
    }
    
    
    /**
     * Macht das Objekt sichtbar / unsichtbar. 
     *
     * @param   sichtbarNeu     true, wenn die Grafik sichtbar sein soll, sonst false
     */
    public void setzeSichtbar( boolean sichtbarNeu ) 
    {
        super.sichtbarSetzen( sichtbarNeu );
    }
    
    
    /**
     * Prueft, od dieses Objekt gerade sichtbar ist. 
     *
     * @return  true, wenn die Grafik gerade sichbar ist, sonst false
     */
    public boolean nenneSichtbar()
    {
        return super.sichtbar();
    }
    
    
    /**
     * Dreht die Grafik um den angegebenen Winkel. 
     *
     * @param   winkelAenderung     +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void drehenUm( float winkelAenderung )
    {
        this.drehenRelativ( -winkelAenderung );
    }
    
    
    /**
     * Setzt den Drehwinkel auf einen absoluten neuen Wert. 
     * Die Orientierung unmittelbar nach dem Erzeugen des Objekts entspricht Winkel 0.
     *
     * @param   neuerDrehwinkel     der neue Drehwinkel
     *                              +: mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *                              -: mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public void setzeDrehwinkel(float neuerDrehwinkel)
    {
        this.drehenAbsolut( -neuerDrehwinkel );
    }
    
    
    /**
     * Nennt den Winkel, um den die Grafik gegenueber ihrer Erzeugung gedreht wurde. 
     *
     * @return      der Winkel, um den die Grafik gedreht wurde
     *              0: wenn nicht gedreht
     *              +: wenn mathematisch positiver Drehsinn (gegen den Uhrzeigersinn)
     *              -: wenn mathematisch negativer Drehsinn (im Uhrzeigersinn)
     */
    public float nenneWinkel()
    {
        return (float)( -super.gibDrehung() );
    }
    
    
    /**
     * Liefert den Sinus des aktuellen Drehwinkels der Grafik. 
     *
     * @return  Sinus des aktuellen Drehwinkels
     */
    public float sin_Drehwinkel()
    {
        return (float)( Math.sin( super.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * Liefert den Cosinus des aktuellen Drehwinkels der Grafik. 
     *
     * @return  Cosinus des aktuellen Drehwinkels
     */
    public float cos_Drehwinkel()
    {
        return (float)( Math.cos( this.gibDrehung() * Math.PI / 180 ) );
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Objekts vom Mittelpunkt 
     * eines anderen Grafik-Objekts in x-Richtung entfernt ist.
     * 
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Abstand (in Pixeln) dieses Rechtecks vom anderen Grafik-Objekt in x-Richtung 
     *          (>0, wenn dieses Rechteck rechts des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandX( Raum grafikObjekt )
    {
        return super.mittelPunkt().x() - grafikObjekt.mittelPunkt().x();
    }
    
    
    /**
     * Diese Methode prueft, wie weit der Mittelpunkt dieses Objekts vom Mittelpunkt 
     * eines anderen Grafik-Objekts in y-Richtung entfernt ist.
     * 
     * @param   grafikObjekt    Das andere Grafik-Objekt
     * 
     * @return  Abstand (in Pixeln) dieses Kreises vom anderen Grafik-Objekt in y-Richtung 
     *          (>0, wenn dieser Kreis unterhalb des anderen Grafik-Objekts liegt)
     */
    public int berechneAbstandY( Raum grafikObjekt )
    {
        return super.mittelPunkt().x() - grafikObjekt.mittelPunkt().y();
    }
    
    
}
