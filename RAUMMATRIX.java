
/**
 * Beschreiben Sie hier die Klasse RAUMMATRIX.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class RAUMMATRIX
{
    private KNOTEN[] knotenfeld;
    private int[][] adjazenzmatrix;
    private boolean[] besucht;
    
    private int anzahlKnoten;
    private int maxAnzahlKnoten;
    
    private final int infinity = Integer.MAX_VALUE;
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
            System.out.print(knotenfeld[i].getDaten().Raumname.substring(0,2) +"\t");
        }
        System.out.println();
        
        for(int i=0; i < maxAnzahlKnoten; i++) {
            System.out.print(knotenfeld[i].getDaten().Raumname.substring(0,2) +"\t");
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
        for (int i; i < maxAnzahlKnoten; i++)
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
            return i;
        }
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
    
    /**
     * Gibt den Index eines Knotens in der Knotenliste aus
     */
    public int getIndex(KNOTEN k)
    {
        for (int i = 0; i < maxAnzahlKnoten; i++)
        {
            if (k == knotenfeld[i])
            {
                return i;
            }
        }
        return -1;

    }
}