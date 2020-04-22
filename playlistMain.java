package playlist_project;

import java.util.ArrayList;

public class playlistMain {

	public static void main(String[] args) {
		ArrayList<Song> Songs = new ArrayList<Song>();
		Song s1 = new Song(1, "meadow", "lil rxspy", 0, 0);
		Songs.add(s1);
		
		s1.anhören();
		s1.anhören();
		s1.überspringen();
		for(Song s : Songs) {
			s.ausgabe();
			s.ausgabeSP();
		}
	}

}
