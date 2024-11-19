package boardGameRecomendations;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
//		new GUI("\"C:\\Users\\jaceb\\OneDrive\\Desktop\\Software Development\\Java\\JavaPractice\\boardGameRecomendations\\src\\boardGameRecomendations\\games.csv\"");
		File file = new File("games.txt");
		
		if (file.exists()) {
			System.out.println("File was found");
			new GUI(file);
		} else {
			System.out.println("File not found");
		}
//		new GUI(file);
	}
}