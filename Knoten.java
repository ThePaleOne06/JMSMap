
/**
 * Beschreiben Sie hier die Klasse Knoten.
 * 
 * @author (Lennart Schmid) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Knoten
{
    private boolean istFachraum;
    private String Raumname;
    
    
    

    
    Knoten(String Raumname, boolean istFachraum)
    {
      this.Raumname = Raumname;
      this.istFachraum = istFachraum;
      
    }

    String RaumnameGeben()
    {
       return Raumname; 
    }
    
}
