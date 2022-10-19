/**
 * Klasse Taxi_Schlangen_TESTER.
 * 
 * @author      mike ganshorn
 * @version     2014-09-14
 */
public class TaxiSchlangenTester 
extends SPIEL
{
    private LISTE ts;

    /**
     * Konstruktor für Objekte der Klasse Taxi_Schlangen_TESTER
     */
    public TaxiSchlangenTester()
    {
        super(900,640);
        this.setzeHintergrundgrafik("bahnhof.jpg");

        // Schlange der Laenge 3 erzeugen

        System.out.println("TEST startet: ------------------------");
        System.out.println();
        this.ts = new LISTE();
        System.out.println("Neue Taxischlange wurde erzeugt.");
        if (this.ts.istLeer()) 
        {
            System.out.println("Die Schlange ist leer.");
        }
        else 
        {
            System.out.println("FEHLER bei Methode 'istLeer()' oder im Konstruktor!");
        }
        System.out.println();
        this.warte(1000);

        // 3 Taxis erzeugen und einreihen

        System.out.println("--- Erzeuge 3 Taxis und reihe sie ein.");
        System.out.println();
        this.warte(1000);

        boolean b0 = true;
        TAXI t1 = new TAXI("TAXI T 1");
        TEXT kfz1 = new TEXT(900, 380, "TAXI T 1");
        kfz1.setzeFarbe("weiss");
        System.out.println("Ein neues Taxi 'TAXI T 1' wurde erzeugt.");
        boolean b1 = this.ts.hintenEinfuegen(t1);
        this.vorfahren(t1, kfz1, 0);
        if (b1) 
        {
            System.out.println("Taxi 'TAXI T 1' wurde hinten eingereiht.");
        }
        else 
        {
            System.out.println("Einreihen von Taxi 1 FEHLGESCHLAGEN!");
        }
        if (this.ts.nenneAnzahl() == 1) 
        {
            System.out.println("Es befindet sich 1 Taxi in der Schlange.");
        }
        else 
        {
            System.out.println("FEHLER in Methode 'nenneAnzahlAktuell()'!");
            b0 = false;
        }
        System.out.println();
        this.warte(1000);

        TAXI t2 = new TAXI("TAXI T 2");
        TEXT kfz2 = new TEXT(900, 380, "TAXI T 2");
        kfz2.setzeFarbe("weiss");
        System.out.println("Ein neues Taxi 2 wurde erzeugt.");
        boolean b2 = this.ts.hintenEinfuegen(t2);
        this.vorfahren(t2, kfz2, 1);
        if (b2) 
        {
            System.out.println("Taxi 'TAXI T 2' wurde hinten eingereiht.");
        }
        else 
        {
            System.out.println("Einreihen von Taxi 2 FEHLGESCHLAGEN!");
        }
        if ( this.ts.nenneAnzahl() == 2 ) 
        {
            System.out.println("Es befinden sich nun 2 Taxis in der Schlange.");
        }
        else 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
            b0 = false;
        }
        System.out.println();
        this.warte(1000);

        TAXI t3 = new TAXI("TAXI T 3");
        TEXT kfz3 = new TEXT(900, 380, "TAXI T 3");
        kfz3.setzeFarbe("weiss");
        System.out.println("Ein neues Taxi 'TAXI T 3' wurde erzeugt.");
        boolean b3 = this.ts.hintenEinfuegen(t3);
        this.vorfahren(t3, kfz3, 2);
        if (b3) 
        {
            System.out.println("Taxi 'TAXI T 3' wurde hinten eingereiht.");
        }
        else {
            System.out.println("Einreihen von Taxi 3 FEHLGESCHLAGEN !!!");
        }
        if ( this.ts.nenneAnzahl() == 3 ) 
        {
            System.out.println("Es befinden sich 3 Taxis in der Schlange.");
        }
        else 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
            b0 = false;
        }
        System.out.println();
        this.warte(1000);

        
        // Hilfsobjekt um später nicht vorhandenes Taxi entfernen zu können
        TAXI t4 = new TAXI("TAXI T 4");
        t4.setzeSichtbar(false);
        
        // Taxis wieder abfahren lassen
        System.out.println("Die Taxis fahren nacheinander wieder ab.");
        System.out.println();
        this.warte(1000);

        t1 = (TAXI) this.ts.vorneEntfernen();
        this.vorfahren(t1, kfz1, -2);
        if ( this.ts.nenneAnzahl() != 2) 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
        }
        t2 = (TAXI) this.ts.vorneEntfernen();
        this.vorfahren(t2, kfz2, 0);
        if ( this.ts.nenneAnzahl() != 1) 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
        }
        t3 = (TAXI) this.ts.vorneEntfernen();
        this.vorfahren(t3, kfz3, 1);
        boolean b9 = true;
        if ( this.ts.nenneAnzahl() != 0) 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
            b9 = false;
        }
        boolean b6 = t1.nenneInfo().equals("TAXI T 1");
        if (b6) 
        {
            System.out.println("Das Taxi mit KFZ 'TAXI T 1' ist gerade abgefahren.");
        }
        else 
        {
            System.out.println("FEHLER! DAs Taxi mit KFZ '" + t1.nenneInfo() + "' ist abgefahren.");
        }
        
        System.out.println();
        this.warte(1000);
        this.vorfahren(t2, kfz2, -2);
        this.vorfahren(t3, kfz3, 0);
        boolean b7 = t2.nenneInfo().equals("TAXI T 2");
        if (b7) 
        {
            System.out.println("Das Taxi mit KFZ 'TAXI T 2' ist gerade abgefahren.");
        }
        else 
        {
            System.out.println("FEHLER! Das Taxi mit KFZ '" + t2.nenneInfo() + "' ist abgefahren.");
        }
        System.out.println();
        this.warte(1000);
        
        this.vorfahren(t3, kfz3, -2);
        boolean b8 = t3.nenneInfo().equals("TAXI T 3");
        if (b8) 
        {
            System.out.println("Das Taxi mit KFZ 'TAXI T 3' ist gerade abgefahren.");
        }
        else 
        {
            System.out.println("FEHLER! Das Taxi mit KFZ '" + t3.nenneInfo() + "' ist abgefahren.");
        }
        System.out.println();
        this.warte(1000);

        if (!this.ts.istLeer()) 
        {
            System.out.println("FEHLER in der Methode 'istLeer()'!");
            b9 = false;
        }
        else 
        {
            System.out.println("Die Schlange ist leer");
        }
        System.out.println();
        this.warte(1000);

        // Versuch, Taxi aus leerer Schlange zu entnehmen

        System.out.println("Versuche nun, ein Taxi aus der leeren Schlange zu entnehmen.");
        System.out.println();
        this.warte(1000);

        t4 = (TAXI) this.ts.vorneEntfernen();
        boolean b10 = true;
        if ( t4 == null ) 
        {
            System.out.println("Kann kein Taxi aus der leeren Schlange entnehmen.");
        }
        else 
        {
            System.out.println("FEHLER beim Entnehmen aus der leeren Schlange!");
            b10 = false;
        }
        if ( this.ts.nenneAnzahl() == 0 ) 
        {
            System.out.println("Die Schlange ist und bleibt leer.");
        }
        else 
        {
            System.out.println("FEHLER in Methode 'nenneAnzahlAktuell()'!");
            b10 = false;
        }
        System.out.println();
        this.warte(1000);

        // Zusammenfassung

        System.out.println("---------------------------------------");
        System.out.println("Zusammenfassung:");
        System.out.println();
        this.warte(1000);
        if (b0 && b1 && b2 && b3) 
        {
            System.out.println(":-) Einreihen fehlerfrei!");
        }
        else 
        {
            System.out.println(":-( FEHLER beim Einreihen der Taxis!");
        }
        if (b6 && b7 && b8 && b9) 
        {
            System.out.println(":-) Entnehmen fehlerfrei");
        }
        else 
        {
            System.out.println(":-( FEHLER beim Entnehmen der Taxis");
        }
        if (b10) 
        {
            System.out.println(":-) Entnehmen bei leerer Schlange nicht moeglich!");
        }
        else 
        {
            System.out.println(":-( FEHLER beim Entnehmen aus leerer Schlange!");
        }
    }

    @Override
    public void tasteReagieren(int code) {
        // ToDo
    }
    
    private void vorfahren(TAXI t, TEXT kfz, int stelle)
    {
        for(int i = t.nenneMx(); i > stelle * 240 + 150; i = i - 1)
        {
            kfz.setzeMittelpunkt(i, kfz.nenneMy());
            t.setzeMittelpunkt(i, t.nenneMy());
            this.warte(10);
        }
    }

}
