
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
            for(int j=0; j < maxAnzahlKnoten;
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
                if (knotenfeld[i].getDaten == d)
                {
                    System.out.println("Daten bereits vorhanden");
                }
            }
            return i;
        }
    }
    
    /**
     * Gibt den Index eines Knotens in der Knotenliste aus
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
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