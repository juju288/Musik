package playlist_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {

	private Connection con;
	
	public DB() throws SQLException {
		 con = DriverManager.getConnection( "jdbc:mysql://localhost/top50?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "tigerchen20");
	}
	
	public ArrayList<Song> Songorder() throws SQLException {
        ArrayList<Song> song = new ArrayList<Song>();
        String sql = "SELECT * FROM song ORDER sp"; 
        PreparedStatement stmt = con.prepareStatement(sql);
//        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next())
        {
            int Id = rs.getInt("ID");
            String name = rs.getString("Name");
            String interpret = rs.getString("Interpret");
            int sp = rs.getInt("sp");
            int hp = rs.getInt("hp");
            Song s = new Song(Id, name, interpret, sp, hp);
            song.add(s);
        }
        return song;
    }
	

}
