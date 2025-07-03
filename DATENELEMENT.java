
/**
 * @author (Lennart Schmid) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DATENELEMENT
{
    private String raumname;
    private boolean istFachraum;

    public DATENELEMENT(String raumname, boolean istFachraum)
    {
        this.raumname = raumname;
        this.istFachraum = istFachraum;
    }

    public String getRaumname()
    {
        return raumname;
    }
}