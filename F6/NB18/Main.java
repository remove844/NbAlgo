package F6.NB18;

public class Main {

	public static void main(String[] args) {
		Maze m = new Maze();
		m.print();
		if(m.solve()) System.out.println("Lyckades");
		System.out.println();
		m.print();

	}
	

}
