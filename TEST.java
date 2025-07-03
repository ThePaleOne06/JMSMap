
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
       /**Raumnetz = new RAUMMATRIX(8);
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
       **/
       
       
       Raumnetz = new RAUMMATRIX(9);
       //Knoten in Matrix einfügen
       int A101 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A101", true));
       int A102 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A102", true));
       int A103 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A103", true));
       int A104 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A104", true));
       int A105 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A105", true));
       int A106 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A106", true));
       int A107 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A107", true));
       int AT2 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("AT2", false));
       int A109 = Raumnetz.knotenHinzufuegen(new DATENELEMENT("A109", true));
       
       // Kanten in Matrix einfügen
       Raumnetz.kanteHinzufuegen(A101, A102);
       Raumnetz.kanteHinzufuegen(A102, A103);
       Raumnetz.kanteHinzufuegen(A103, A104);
       Raumnetz.kanteHinzufuegen(A104, A105);
       Raumnetz.kanteHinzufuegen(A105, B106);
       Raumnetz.kanteHinzufuegen(A106, A107);
       Raumnetz.kanteHinzufuegen(A107, AT2);
       Raumnetz.kanteHinzufuegen(AT2, A109);
       Raumnetz.kanteHinzufuegen(A107, A109);
       
       
    }

    
}