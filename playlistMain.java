package playlist_project;

import java.sql.SQLException;
import java.util.ArrayList;

public class playlistMain {

	public static void main(String[] args) throws SQLException {
//		ArrayList<Song> Songs = new ArrayList<Song>();
//		Song s1 = new Song(1, "meadow", "lil rxspy", 0, 0);
//		Songs.add(s1);
//		
//		s1.anh�ren();
//		s1.anh�ren();
//		s1.�berspringen();
		
		DB db = new DB();
		db.anh�ren(40);
		
		 ArrayList<Song> so = db.Songorder();
		
		for(Song s : so) {
			s.ausgabe();
		}
	}

	

}
