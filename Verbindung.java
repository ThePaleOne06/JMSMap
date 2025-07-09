import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Verbindung
{
    public static void main(String[] args)
    {
        // NOTE: Connection and Statement are AutoCloseable.
        //       Don't forget to close them both in order to avoid leaks.
        try
        (
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:datenbank.db");
        Statement statement = connection.createStatement();
        )
        {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            // Drop and create Rooms table
            statement.executeUpdate("drop table if exists Rooms");
            statement.executeUpdate("create table Rooms (id string primary key, floor integer, notes string, usage string)");

            // Insert sample data into Rooms table
            statement.executeUpdate("insert into Rooms values('A014', 1, NULL, 'Meetings')");
            statement.executeUpdate("insert into Rooms values('A123', 2, NULL, 'Experiments')");
            statement.executeUpdate("insert into Rooms values('A202', 3, NULL, 'Lectures')");

            // Retrieve and print data from Rooms table
            ResultSet rsRooms = statement.executeQuery("select * from Rooms");
            while (rsRooms.next()) {
                System.out.println("id:" + rsRooms.getString("id") + " | floor:" + rsRooms.getInt("floor") + " | notes:" + rsRooms.getString("notes") + " | usage:" + rsRooms.getString("usage"));
            }
            ResultSet nullRoom = statement.executeQuery("select * from Rooms WHERE notes IS NULL");
            while (rsRooms.next()) {
                System.out.println("NULL: Room with id " + nullRoom.getInt("id"));
            }
            // Drop and create Timetable table
            statement.executeUpdate("drop table if exists Timetable");
            statement.executeUpdate("create table Timetable (time integer primary key, room string, class string, teacher string)");

            // Insert sample data into Timetable table
            statement.executeUpdate("insert into Timetable values('102', 'A014', 'Math', 'Mr. Smith')");
            statement.executeUpdate("insert into Timetable values('103', 'A123', 'Science', 'Dr. Jones')");
            statement.executeUpdate("insert into Timetable values('104', 'A202', 'History', 'Mrs. Brown')");

            // Retrieve and print data from Timetable table
            ResultSet rsTimetable = statement.executeQuery("select * from Timetable");
            while (rsTimetable.next()) {
                System.out.println("time:" + rsTimetable.getInt("time") + " | room:" + rsTimetable.getInt("room") + " | class:" + rsTimetable.getString("class") + " | teacher:" + rsTimetable.getString("teacher"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace(System.err);
        }
    }
}