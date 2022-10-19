public class WartelistenTester 
extends SPIEL
{
    private LISTE wl;

    /**
     * Konstruktor für Objekte der Klasse Patient_Wartelisten_TESTER
     */
    public WartelistenTester()
    {
        super(900,640);
        this.setzeHintergrundgrafik("krankenhaus.png");

        // Warteliste der Laenge 3 erzeugen

        System.out.println("TEST startet: ------------------------");
        System.out.println();
        this.wl = new LISTE();
        System.out.println("Neue Warteliste wurde erzeugt.");
        if (this.wl.istLeer()) 
        {
            System.out.println("Die Warteliste ist leer.");
        }
        else 
        {
            System.out.println("FEHLER bei Methode 'istLeer()' oder im Konstruktor!");
        }
        System.out.println();
        this.warte(1000);

        // 3 Patients erzeugen und einreihen

        System.out.println("--- Erzeuge 3 Patienten und reihe sie ein.");
        System.out.println();
        this.warte(1000);

        boolean b0 = true;
        PATIENT p1 = new PATIENT("Horst", 'm', "Alzheimer", "Passau");
        TEXT name1 = new TEXT(900, 235, "Horst");
        name1.setzeFarbe("weiss");
        System.out.println("Ein neuer Patient 'Horst' wurde erzeugt.");
        boolean b1 = this.wl.hintenEinfuegen(p1);
        this.vorgehen(p1, name1, 0);
        if (b1) 
        {
            System.out.println("Patient 'Horst' wurde hinten eingereiht.");
        }
        else 
        {
            System.out.println("Einreihen von Patient 1 FEHLGESCHLAGEN!");
        }
        if (this.wl.nenneAnzahl() == 1) 
        {
            System.out.println("Es befindet sich 1 Patient in der Warteliste.");
        }
        else 
        {
            System.out.println("FEHLER in Methode 'nenneAnzahlAktuell()'!");
            b0 = false;
        }
        System.out.println();
        this.warte(1000);

        PATIENT p2 = new PATIENT("Baerbel", 'w', "Schnupfen", "Muenchen");
        TEXT name2 = new TEXT(900, 235, "Baerbel");
        name2.setzeFarbe("weiss");
        System.out.println("Eine neue Patientin 2 wurde erzeugt.");
        boolean b2 = this.wl.hintenEinfuegen(p2);
        this.vorgehen(p2, name2, 1);
        if (b2) 
        {
            System.out.println("Patientin 'Baerbel' wurde hinten eingereiht.");
        }
        else 
        {
            System.out.println("Einreihen von Patientin 2 FEHLGESCHLAGEN!");
        }
        if ( this.wl.nenneAnzahl() == 2 ) 
        {
            System.out.println("Es befinden sich nun 2 Patienten in der Warteliste.");
        }
        else 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
            b0 = false;
        }
        System.out.println();
        this.warte(1000);

        PATIENT p3 = new PATIENT("Thomas", 'm', "Grippe", "Landshut");
        TEXT name3 = new TEXT(900, 235, "Thomas");
        name3.setzeFarbe("weiss");
        System.out.println("Ein neuer Patient 'Thomas' wurde erzeugt.");
        boolean b3 = this.wl.hintenEinfuegen(p3);
        this.vorgehen(p3, name3, 2);
        if (b3) 
        {
            System.out.println("Patient 'Thomas' wurde hinten eingereiht.");
        }
        else {
            System.out.println("Einreihen von Patient 3 FEHLGESCHLAGEN !!!");
        }
        if ( this.wl.nenneAnzahl() == 3 ) 
        {
            System.out.println("Es befinden sich 3 Patienten in der Warteliste.");
        }
        else 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
            b0 = false;
        }
        System.out.println();
        this.warte(1000);

        // Hilfsobjekt um später nicht vorhandenen Patienten entfernen zu können
         PATIENT p4 = new PATIENT("Julia", 'w', "Kopfweh", "Regensburg");
         p4.setzeSichtbar(false);
        
        

        // Patients wieder abfahren lassen
        System.out.println("Die Patienten gehen nacheinander zum Onkel Doktor.");
        System.out.println();
        this.warte(1000);

        p1 = (PATIENT) this.wl.vorneEntfernen();
        this.vorgehen(p1, name1, -1);
        if ( this.wl.nenneAnzahl() != 2) 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
        }
        p2 = (PATIENT) this.wl.vorneEntfernen();
        this.vorgehen(p2, name2, 0);
        if ( this.wl.nenneAnzahl() != 1) 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
        }
        p3 = (PATIENT) this.wl.vorneEntfernen();
        this.vorgehen(p3, name3, 1);
        boolean b9 = true;
        if ( this.wl.nenneAnzahl() != 0) 
        {
            System.out.println("FEHLER in der Methode 'nenneAnzahlAktuell()'!");
            b9 = false;
        }
        boolean b6 = p1.nenneInfo().equals("Horst");
        if (b6) 
        {
            System.out.println("Der Patient 'Horst' ist gerade zum Onkel Doktor gegangen.");
        }
        else 
        {
            System.out.println("FEHLER! Der Patient '" + p1.nenneInfo() + "' ist gerade zum Onkel Doktor gegangen.");
        }
        
        System.out.println();
        this.warte(1000);
        this.vorgehen(p2, name2, -1);
        this.vorgehen(p3, name3, 0);
        boolean b7 = p2.nenneInfo().equals("Baerbel");
        if (b7) 
        {
            System.out.println("Die Patientin 'Baerbel' ist gerade zum Onkel Doktor gegangen.");
        }
        else 
        {
            System.out.println("FEHLER! Die Patientin '" + p2.nenneInfo() + "' ist gerade zum Onkel Doktor gegangen.");
        }
        System.out.println();
        this.warte(1000);
        
        this.vorgehen(p3, name3, -1);
        boolean b8 = p3.nenneInfo().equals("Thomas");
        if (b8) 
        {
            System.out.println("Der Patient 'Thomas' ist gerade zum Onkel Doktor gegangen.");
        }
        else 
        {
            System.out.println("FEHLER! Der Patient '" + p3.nenneInfo() + "' ist gerade zum Onkel Doktor gegangen.");
        }
        System.out.println();
        this.warte(1000);

        if (!this.wl.istLeer()) 
        {
            System.out.println("FEHLER in der Methode 'istLeer()'!");
            b9 = false;
        }
        else 
        {
            System.out.println("Die Warteliste ist leer");
        }
        System.out.println();
        this.warte(1000);

        // Versuch, Patient aus leerer Warteliste zu entnehmen

        System.out.println("Versuche nun, einen Patienten aus der leeren Warteliste zu entnehmen.");
        System.out.println();
        this.warte(1000);

        p4 = (PATIENT) this.wl.vorneEntfernen();
        boolean b10 = true;
        if ( p4 == null ) 
        {
            System.out.println("Kann keinen Patienten aus der leeren Warteliste entnehmen.");
        }
        else 
        {
            System.out.println("FEHLER beim Entnehmen aus der leeren Warteliste!");
            b10 = false;
        }
        if ( this.wl.nenneAnzahl() == 0 ) 
        {
            System.out.println("Die Warteliste ist und bleibt leer.");
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
            System.out.println(":-( FEHLER beim Einreihen der Patienten!");
        }
        if (b6 && b7 && b8 && b9) 
        {
            System.out.println(":-) Entnehmen fehlerfrei");
        }
        else 
        {
            System.out.println(":-( FEHLER beim Entnehmen der Patienten");
        }
        if (b10) 
        {
            System.out.println(":-) Entnehmen bei leerer Warteliste nicht moeglich!");
        }
        else 
        {
            System.out.println(":-( FEHLER beim Entnehmen aus leerer Warteliste!");
        }
    }

    @Override
    public void tasteReagieren(int code) {
        // ToDo
    }
    
    private void vorgehen(PATIENT p, TEXT name, int stelle)
    {
        for(int i = p.nenneMx(); i > stelle * 130 + 500; i = i - 1)
        {
            name.setzeMittelpunkt(i, name.nenneMy());
            p.setzeMittelpunkt(i, p.nenneMy());
            this.warte(10);
        }
        if(stelle < 0)
        {
            p.setzeSichtbar(false);
            name.setzeSichtbar(false);
        }
    }

}
