
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
}