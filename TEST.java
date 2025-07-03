
/**
 * Beschreiben Sie hier die Klasse TEST.
 * 
 * @author (Lennart Schmid) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TEST
{
    private RAUMMATRIX raumnetz;

    
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
       
       
       raumnetz = new RAUMMATRIX(9);
       //Knoten in Matrix einfügen
       int A101 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A101", true));
       int A102 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A102", true));
       int A103 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A103", true));
       int A104 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A104", true));
       int A105 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A105", true));
       int A106 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A106", true));
       int A107 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A107", true));
       int AT2 = raumnetz.KnotenEinfuegen(new DATENELEMENT("AT2", false));
       int A109 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A109", true));
       
       // Kanten in Matrix einfügen
       raumnetz.kanteEinfuegen(A101, A102);
       raumnetz.kanteEinfuegen(A102, A103);
       raumnetz.kanteEinfuegen(A103, A104);
       raumnetz.kanteEinfuegen(A104, A105);
       raumnetz.kanteEinfuegen(A105, A106);
       raumnetz.kanteEinfuegen(A106, A107);
       raumnetz.kanteEinfuegen(A107, AT2);
       raumnetz.kanteEinfuegen(AT2, A109);
       raumnetz.kanteEinfuegen(A107, A109);
       
       
    }

    
}