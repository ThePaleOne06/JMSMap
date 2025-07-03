
/**
 * Beschreiben Sie hier die Klasse TEST.
 * 
 * @author (Lennart Schmid) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TEST
{
    private RAUMMATRIX Raumnetz;

    
    public TEST()
    {
       Raumnetz = new RAUMMATRIX(8);
       // Knoten Hinzufügen zur Matrix 
        int B101 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B101", false)); 
       int B102 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B102", false));
       int B103 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B103", false));
       int B104 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B104", false));
       int B105 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B105", false));
       int B115 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B115", false));
       int B116 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B116", false));
       int B117 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B117", false));
       int BIB = Raumnetz.knotenHinzufuegen(new DATENELEMENT("B117", false));
       
       // Kanten Hinzufügen zur Matrix
       
       Raumnetz.kanteHinzufuegen(B101, B102, 1);
       Raumnetz.kanteHinzufuegen(B102, B103, 1);
       Raumnetz.kanteHinzufuegen(B103, B104, 1);
       Raumnetz.kanteHinzufuegen(B104, B105, 1);
       Raumnetz.kanteHinzufuegen(B115, B116, 1);
       Raumnetz.kanteHinzufuegen(B116, BIB, 1);
       Raumnetz.kanteHinzufuegen(BIB, B117, 1);
       
    }

    
}