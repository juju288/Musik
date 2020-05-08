package playlist_project;

public class Song  {
	
	private int id;
	private String name;
	private String interpret;
	private int sp;
	private int hp;
	
	public Song(int ID, String Name, String Interpret, int Sympathiepunkte, int Häufigkeitspunkte ) {
		this.id = ID;
		this.name = Name;
		this.interpret = Interpret;
		this.hp = Häufigkeitspunkte;
		this.sp = Sympathiepunkte;
	}
	
	
	
//	public void ausgabeSP() {
//		System.out.printf("Hp: %d	| Sp: %d	| ID: %d \n", hp, sp, id);
//	}
	
	
	public void ausgabe() {
		System.out.printf("ID: %2d	| Song: %-64s	| Interpret: %s \n", id, name, interpret);
	}
}
