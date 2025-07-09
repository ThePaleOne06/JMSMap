import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Beschreiben Sie hier die Klasse Anweisung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Datenbank {
    private Connection connection;
    public Datenbank() {
        try {
            // Verbindung zur Datenbank herstellen im Konstruktor
            connection = DriverManager.getConnection("jdbc:sqlite:datenbank.db");
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
    public boolean setNotes(String room, String note){
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("update Rooms set notes = '" + note + "' where id = '" + room + "'" );
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return true;
    }

    private String getTableInfo(String column, String identifier, boolean isTime) {
        // ZWEI METHODEN WEGEN ZWEI DATENBANKEN
    
        String query = isTime ? "select * from Timetable where time is " + identifier 
            : "select * from Rooms where id = '" + identifier + "'";
        try (Statement statement = connection.createStatement()) {
            ResultSet rsTable = statement.executeQuery(query);
            if (rsTable.next()) { // Ensure there's a result
                return rsTable.getString(column);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    public String getRoom(int time) {
        return getTableInfo("room", Integer.toString(time), true);
    }

    public String getClass(int time) {
        return getTableInfo("class", Integer.toString(time), true);
    }

    public String getTeacher(int time) {
        return getTableInfo("teacher", Integer.toString(time), true);
    }

    public int getFloor(String room) {
        return Integer.parseInt(getTableInfo("floor", room, false));
    }

    public String getNotes(String room) {
        return getTableInfo("notes", room, false);
    }

    public String getUsage(String room) {
        return getTableInfo("usage", room, false);
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
