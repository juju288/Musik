
package application;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	private DB db;

	public static void main(String[] args) throws SQLException {
		DB db = new DB();
//		db.anhören();
		db.wiedergabe();
//		 ArrayList<Song> so = db.Songorder();
		
//		for(Song s : so) {
//			
//			s.ausgabe();
//		}
	}
}

