import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse RAUMMATRIX.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class RAUMMATRIX
{
    private KNOTEN[] knotenfeld;
    private ArrayList<String> optimalerWeg;
    private ArrayList<String> aktuellerWeg;
    private int[][] adjazenzmatrix;
    private boolean[] besucht;
    
    private Datenbank db = new Datenbank();
    private int anzahlKnoten;
    private int maxAnzahlKnoten;
    
    private final int infinity = Integer.MAX_VALUE;
    private int optimalelaenge;
    private String aktWeg = "";
    private int aktLaenge = 0;
    

    /**
     * Konstruktor für Objekte der Klasse RAUMMATRIX
     */
    public RAUMMATRIX(int maxAnzahlKnoten)
    {
        anzahlKnoten = 0;
        knotenfeld = new KNOTEN[maxAnzahlKnoten];
        besucht = new boolean[maxAnzahlKnoten];
        adjazenzmatrix = new int[maxAnzahlKnoten][maxAnzahlKnoten];
        optimalerWeg = new ArrayList<String>();
        aktuellerWeg = new ArrayList<String>();
        this.maxAnzahlKnoten = maxAnzahlKnoten;
            
        for(int i=0; i < maxAnzahlKnoten; i=i+1) {
            for(int j=0; j < maxAnzahlKnoten; j=j+1) {
                if(i==j) {
                    adjazenzmatrix[i][j] = 0;
                }
                else {
                    adjazenzmatrix[i][j] = 0;
                }
            }
        }
    }
    

    public void matrixAusgeben() {
        for(int i=0; i< maxAnzahlKnoten; i++) {
            for(int j=0; j < maxAnzahlKnoten; j++) {
                System.out.print(adjazenzmatrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
    
    public void matrixAusgebenVerbindungen() {
        System.out.print("\t");
        for(int i=0; i < maxAnzahlKnoten; i++) {
            System.out.print(knotenfeld[i].getDaten().getRaumname().substring(0,2) +"\t");
        }
        System.out.println();
        
        for(int i=0; i < maxAnzahlKnoten; i++) {
            System.out.print(knotenfeld[i].getDaten().getRaumname().substring(0,2) +"\t");
            for(int j=0; j < maxAnzahlKnoten; j++) {
                System.out.print(adjazenzmatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    /**
     * fügt einen Knoten dem Knotenfeld hinzu
     */
    public int KnotenEinfuegen(DATENELEMENT d)
    {
        int i = 0;
        for (; i < maxAnzahlKnoten; i++)
        {
            if (knotenfeld[i] == null)
            {
                knotenfeld[i] = new KNOTEN(d);break;
            }
            else
            {
                if (knotenfeld[i].getDaten() == d)
                {
                    System.out.println("Daten bereits vorhanden");
                }
            }
            
        }
        return i;
    }
    
    /**
     * fügt eine Kante in die Matrix ein
     */
    public void kanteEinfuegen(int start, int ziel)
    {
        if (start >= 0 && ziel >= 0 && start != ziel && start < maxAnzahlKnoten && ziel < maxAnzahlKnoten)
        {
            //erst Reihe, dann Spalte
            adjazenzmatrix[start][ziel] = 1;
            adjazenzmatrix[ziel][start] = 1;
        }
    }
    
    public void tiefensucheStarten(int aktuelleZeit)
    {
        tiefensuche(getIndex(db.getRoom(aktuelleZeit)), getIndex(db.getRoom(aktuelleZeit + 1)));
    }
    
    /**
     * Gibt den Index eines Knotens in der Knotenliste aus
     */
    public int getIndex(String knotenName)
    {
        for (int i = 0; i < maxAnzahlKnoten; i++)
        {
            if (knotenName == knotenfeld[i].daten.getRaumname())
            {
                return i;
            }
        }
        return -1;

    }
    
    public void tiefensucheSchritt(int aktuell, int zielknotenIdx, int laenge) {
        besucht[aktuell]=true;
        aktuellerWeg.add(knotenfeld[aktuell].getDaten().getRaumname());
        System.out.println(knotenfeld[aktuell].getDaten().getRaumname());
        if(aktuell == zielknotenIdx){
            System.out.println("ZIEL");
            if(laenge < optimalelaenge){
                optimalelaenge = laenge;
                optimalerWeg = (ArrayList<String>) aktuellerWeg.clone();
            }
            
        }
        else{
            for(int i=0; i < maxAnzahlKnoten; i++) {
                if(adjazenzmatrix[aktuell][i] > 0 && besucht[i]==false) {
                    tiefensucheSchritt(i, zielknotenIdx, laenge + 1);
                }
            }
        }
        besucht[aktuell]=false;
        aktuellerWeg.remove(knotenfeld[aktuell].getDaten().getRaumname());
    }
    
    public void tiefensuche(int startKnotenIdx, int zielKnotenIdx) {
        for(int i=0; i < maxAnzahlKnoten; i++) {
            besucht[i]=false;
        }
        optimalerWeg.clear();
        aktuellerWeg.clear();
        optimalelaenge = infinity;
        tiefensucheSchritt(startKnotenIdx, zielKnotenIdx, 0);
        System.out.println("länge "+optimalelaenge);
        System.out.println("Weg "+optimalerWeg);
    }
    
    public boolean istZusammenhaengend() {
        boolean ergebnis=false;
        
        return ergebnis;
    }
}