package playlist_project;

public class Song  {
	
	private int id;
	private String name;
	private String interpret;
	private int sp;
	private int hp;
	
	public Song(int ID, String Name, String Interpret, int Sympathiepunkte, int H�ufigkeitspunkte ) {
		this.id = ID;
		this.name = Name;
		this.interpret = Interpret;
		this.hp = H�ufigkeitspunkte;
		this.sp = Sympathiepunkte;
	}
	
	
	public int Wiedergabe() {
//		int z = (int) (Math.random() * 50) + 1;
		return id;
	}
	
	public void �berspringen() {
//		int Id = Wiedergabe();
//		if(Id == id) {
			sp--;
			hp++;
//		}
	}
	
	public void anh�ren() {
//		int Id = Wiedergabe();
//		if(Id == id) {
			sp++;
			hp++;
//		}
	}
	
	public void favoriten() {
		//sp von gro� nach klein sortieren
		// wenn sp gleich, entscheiden kleinere hp
	}
	
	
	public void ausgabeSP() {
		System.out.printf("Hp: %d	| Sp: %d	| ID: %d \n", hp, sp, id);
	}
	
	
	public void ausgabe() {
		System.out.printf("ID: %d	| Song: %s	| Interpret: %s \n", id, name, interpret);
	}
}
