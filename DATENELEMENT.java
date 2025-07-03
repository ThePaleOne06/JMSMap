
/**
 * @author (Lennart Schmid) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DATENELEMENT
{
    private String Raumname;
    private boolean istFachraum;

    public DATENELEMENT(String raumname, boolean istFachraum)
    {
        this.Raumname = raumname;
        this.istFachraum = istFachraum;
    }

    public String getRaumname()
    {
        return Raumname;
    }
}