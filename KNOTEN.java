
/** 
 * @author (Lennart Schmid) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class KNOTEN
{
    public DATENELEMENT daten;

    
    public KNOTEN(DATENELEMENT inhalt)
    {
        daten = inhalt;
    }

    public DATENELEMENT datenLiefern(){
        return daten;
    }
}