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
            // Create the Timetable table with the specified schema
            statement.executeUpdate("create table Timetable (time integer primary key, room string, class string, teacher string)");

            // Insert sample data into Timetable table for all combinations of day (1-5) and hour (1-6)
            statement.executeUpdate("insert into Timetable values(101, 'A101', 'Mathematics', 'Mr. Johnson')");
            statement.executeUpdate("insert into Timetable values(102, 'A102', 'Biology', 'Dr. Emily')");
            statement.executeUpdate("insert into Timetable values(103, 'A103', 'Chemistry', 'Ms. Davis')");
            statement.executeUpdate("insert into Timetable values(104, 'A104', 'Physics', 'Mr. Brown')");
            statement.executeUpdate("insert into Timetable values(105, 'A105', 'English Literature', 'Ms. Wilson')");
            statement.executeUpdate("insert into Timetable values(106, 'A106', 'History', 'Mr. Thompson')");

            statement.executeUpdate("insert into Timetable values(201, 'A107', 'Art', 'Ms. Taylor')");
            statement.executeUpdate("insert into Timetable values(202, 'A110', 'Music', 'Mr. Anderson')");
            statement.executeUpdate("insert into Timetable values(203, 'A111', 'Physical Education', 'Ms. Martinez')");
            statement.executeUpdate("insert into Timetable values(204, 'A112', 'Computer Science', 'Mr. Clark')");
            statement.executeUpdate("insert into Timetable values(205, 'A113', 'Geography', 'Ms. Lewis')");
            statement.executeUpdate("insert into Timetable values(206, 'A113', 'Math', 'Ms. Beans')");

            statement.executeUpdate("insert into Timetable values(301, 'A114', 'Drama', 'Ms. Robinson')");
            statement.executeUpdate("insert into Timetable values(302, 'A115', 'Economics', 'Mr. White')");
            statement.executeUpdate("insert into Timetable values(303, 'A116', 'Psychology', 'Dr. Harris')");
            statement.executeUpdate("insert into Timetable values(304, 'A117', 'Sociology', 'Ms. Walker')");
            statement.executeUpdate("insert into Timetable values(305, 'A118', 'Philosophy', 'Mr. Hall')");
            statement.executeUpdate("insert into Timetable values(306, 'A119', 'Statistics', 'Ms. Allen')");

            statement.executeUpdate("insert into Timetable values(401, 'A120', 'Environmental Science', 'Dr. Young')");
            statement.executeUpdate("insert into Timetable values(402, 'A121', 'Business Studies', 'Mr. King')");
            statement.executeUpdate("insert into Timetable values(403, 'A101', 'Creative Writing', 'Ms. Wright')");
            statement.executeUpdate("insert into Timetable values(404, 'A102', 'Health Education', 'Mr. Scott')");
            statement.executeUpdate("insert into Timetable values(405, 'A103', 'Digital Media', 'Ms. Green')");
            statement.executeUpdate("insert into Timetable values(406, 'A104', 'Web Development', 'Mr. Adams')");

            statement.executeUpdate("insert into Timetable values(501, 'Durchgang', 'Graphic Design', 'Ms. Nelson')");
            statement.executeUpdate("insert into Timetable values(502, 'WC', 'Robotics', 'Mr. Carter')");
            statement.executeUpdate("insert into Timetable values(503, 'Treppe', 'Advanced Mathematics', 'Ms. Mitchell')");
            statement.executeUpdate("insert into Timetable values(504, 'Durchgang', 'Literature', 'Mr. Perez')");
            statement.executeUpdate("insert into Timetable values(505, 'WC', 'Foreign Languages', 'Ms. Roberts')");
            statement.executeUpdate("insert into Timetable values(506, 'Treppe', 'Data Science', 'Mr. Turner')");
            // Retrieve and print data from Timetable table
            ResultSet rsTimetable = statement.executeQuery("select * from Timetable");
            while (rsTimetable.next()) {
                System.out.println("time:" + rsTimetable.getInt("time") + " | room:" + rsTimetable.getString("room") + " | class:" + rsTimetable.getString("class") + " | teacher:" + rsTimetable.getString("teacher"));
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