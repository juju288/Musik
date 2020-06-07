package application;

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
        String sql = "SELECT * FROM songs ORDER BY sp desc"; 
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
        rs.close();
		stmt.close();
        return song;
    }
	
	
	public String wiedergabe() throws SQLException{
		int id = (int) (Math.random() * 50) + 1;
		String sql = "SELECT Name FROM songs WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs =  stmt.executeQuery();
	        
        String name = new String();
	   	 while (rs.next())
			{
				name = rs.getString("Name");
				System.out.println(name);
				
			}
		stmt.close();
		return name;
	}
	
	
	public void anhören(int id) throws SQLException {
		String sql = "UPDATE songs SET sp = sp + 1 WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
		stmt.executeUpdate();
        
        sql = "UPDATE songs SET hp = hp + 1 WHERE ID = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
		stmt.close();
	}
	
	public void überspringen(int id) throws SQLException {
		String sql = "UPDATE songs SET sp = sp - 1 WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
		stmt.executeUpdate();
        
        sql = "UPDATE songs SET hp = hp + 1 WHERE ID = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);     
		stmt.close();
	}
	
}
