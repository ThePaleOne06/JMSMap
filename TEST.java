
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

       /**


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
       
       Raumnetz.kanteHinzufuegen(B101, B102);
       Raumnetz.kanteHinzufuegen(B102, B103);
       Raumnetz.kanteHinzufuegen(B103, B104);
       Raumnetz.kanteHinzufuegen(B104, B105);
       Raumnetz.kanteHinzufuegen(B115, B116);
       Raumnetz.kanteHinzufuegen(B116, BIB);
       Raumnetz.kanteHinzufuegen(BIB, B117);
       **/
       
       
       raumnetz = new RAUMMATRIX(46);
       //Knoten des ersten Stocks in Matrix einfügen
       int A101 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A101", true));
       int A102 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A102", true));
       int A103 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A103", true));
       int A104 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A104", true));
       int A105 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A105", true));
       int A106 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A106", true));
       int A107 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A107", true));
       int A108 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A108", false));
       int A110 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A110", true));
       int A111 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A111", true));
       int A112 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A112", true));
       int A113 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A113", true));
       int A114 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A114", false));
       int Durchgang = raumnetz.KnotenEinfuegen(new DATENELEMENT("Durchgang", false));
       int WC = raumnetz.KnotenEinfuegen(new DATENELEMENT("WC", false));
       int A115 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A115", true));
       int A116 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A116", false));
       int A117 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A117", true));
       int A118 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A118", true));
       int A119 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A119", true));
       int A120 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A120", true));
       int A121 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A121", true));
       int Treppe = raumnetz.KnotenEinfuegen(new DATENELEMENT("Treppe", false));
       
       //Knoten des zweiten Stocks in Matrix einfügen
       
        
       int A201 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A201", false));
       int A202 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A202", false));
       int A203 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A203", false));
       int A204 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A204", false));
       int A205 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A205", false));
       int A206 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A206", false));
       int A207 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A207", false));
       int A208 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A208", false));
       int A210 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A210", false));
       int A211 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A211", false));
       int A212 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A212", false));
       int A213 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A213", false));
       int A214 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A214", false));
       int Durchgang2 = raumnetz.KnotenEinfuegen(new DATENELEMENT("Durchgang", false));
       int WC2 = raumnetz.KnotenEinfuegen(new DATENELEMENT("WC", false));
       int A215 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A215", false));
       int A216 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A216", false));
       int A217 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A217", false));
       int A218 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A218", false));
       int A219 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A219", true));
       int A220 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A220", true));
       int A221 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A221", false));
       int Treppe2 = raumnetz.KnotenEinfuegen(new DATENELEMENT("Treppe2", false));
       
       
       
       
       
       // Kanten im ersten Stock in Matrix einfügen
       raumnetz.kanteEinfuegen(A101, A102);
       raumnetz.kanteEinfuegen(A102, A103);
       raumnetz.kanteEinfuegen(A103, A104);
       raumnetz.kanteEinfuegen(A104, A105);
       raumnetz.kanteEinfuegen(A105, A106);
       raumnetz.kanteEinfuegen(A106, A107);
       raumnetz.kanteEinfuegen(A107, A108);
       raumnetz.kanteEinfuegen(A108, A110);
       raumnetz.kanteEinfuegen(A110, A111);
       raumnetz.kanteEinfuegen(A111, A112);
       raumnetz.kanteEinfuegen(A112, A113);
       raumnetz.kanteEinfuegen(A113, A114);
       
       raumnetz.kanteEinfuegen(A114, Durchgang);
       raumnetz.kanteEinfuegen(Durchgang, WC);
       raumnetz.kanteEinfuegen(WC, A115);
       raumnetz.kanteEinfuegen(A115, A116);
       raumnetz.kanteEinfuegen(A116, A117);
       raumnetz.kanteEinfuegen(A117, A118);
       raumnetz.kanteEinfuegen(A118, A119);
       raumnetz.kanteEinfuegen(A119, A120);
       raumnetz.kanteEinfuegen(A120, A121);
       raumnetz.kanteEinfuegen(A121, Treppe);
       raumnetz.kanteEinfuegen(Treppe, A101);
       
       // Kanten im zweiten Stock in Matrix einfügen
       
       raumnetz.kanteEinfuegen(A201, A202);
       raumnetz.kanteEinfuegen(A202, A203);
       raumnetz.kanteEinfuegen(A203, A204);
       raumnetz.kanteEinfuegen(A204, A205);
       raumnetz.kanteEinfuegen(A205, A206);
       raumnetz.kanteEinfuegen(A206, A207);
       raumnetz.kanteEinfuegen(A207, A208);
       raumnetz.kanteEinfuegen(A208, A210);
       raumnetz.kanteEinfuegen(A210, A211);
       raumnetz.kanteEinfuegen(A211, A212);
       raumnetz.kanteEinfuegen(A212, A213);
       raumnetz.kanteEinfuegen(A213, A214);
       raumnetz.kanteEinfuegen(A214, A215);
       raumnetz.kanteEinfuegen(A214, Durchgang2);
       raumnetz.kanteEinfuegen(Durchgang2, WC2);
       raumnetz.kanteEinfuegen(WC2, A215);
       raumnetz.kanteEinfuegen(A215, A216);
       raumnetz.kanteEinfuegen(A216, A217);
       raumnetz.kanteEinfuegen(A217, A218);
       raumnetz.kanteEinfuegen(A218, A219);
       raumnetz.kanteEinfuegen(A219, A220);
       raumnetz.kanteEinfuegen(A220, A221);
       raumnetz.kanteEinfuegen(A221, Treppe2);
       raumnetz.kanteEinfuegen(Treppe2, A201);
       raumnetz.kanteEinfuegen(Treppe, Treppe2);
       
       raumnetz.tiefensucheStarten(202);
       

    }
    
    

    }

