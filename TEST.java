
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
       int A110 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A110", true));
       int A111 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A111", true));
       int A112 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A112", true));
       int A113 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A113", true));
       int A114 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A114", false));
       int A115 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A115", true));
       int A117 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A118", true));
       int A118 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A119", true));
       int A120 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A120", true));
       int A121 = raumnetz.KnotenEinfuegen(new DATENELEMENT("A121", true));
       int AT1 = raumnetz.KnotenEinfuegen(new DATENELEMENT("AT1", false));
       
       
       
       
       // Kanten in Matrix einfügen
       raumnetz.kanteEinfuegen(A101, A102);
       raumnetz.kanteEinfuegen(A102, A103);
       raumnetz.kanteEinfuegen(A103, A104);
       raumnetz.kanteEinfuegen(A104, A105);
       raumnetz.kanteEinfuegen(A105, A106);
       raumnetz.kanteEinfuegen(A106, A107);
       raumnetz.kanteEinfuegen(A107, AT2);
       raumnetz.kanteEinfuegen(AT2, A109);
       raumnetz.kanteEinfuegen(A109, A110);
       raumnetz.kanteEinfuegen(A110, A111);
       raumnetz.kanteEinfuegen(A111, A112);
       raumnetz.kanteEinfuegen(A112, A113);
       raumnetz.kanteEinfuegen(A113, A114);
       raumnetz.kanteEinfuegen(A114, A115);
       raumnetz.kanteEinfuegen(A117, A118);
       raumnetz.kanteEinfuegen(A118, A120);
       raumnetz.kanteEinfuegen(A120, A121);
       raumnetz.kanteEinfuegen(A121, AT1);
       raumnetz.kanteEinfuegen(AT1, A101);
       

       int Zeit = 304;
       raumnetz.tiefensucheStarten(Zeit);

       
       
    }
    
    void test_matrix() {
        Datenbank db = new Datenbank();
        System.out.println(db.getRoom(102));
        System.out.println(db.getClass(102));
        System.out.println(db.getTeacher(102));
        System.out.println(db.getFloor(db.getRoom(102)));
        System.out.println(db.getNotes(db.getRoom(102)));
        System.out.println(db.getUsage(db.getRoom(102)));
        db.setNotes(db.getRoom(102), "hello");
        System.out.println(db.getNotes(db.getRoom(102)));
        5c0dbfaf57e196b8a9e03aaac98e1acc4424a2e3
    }

    
}