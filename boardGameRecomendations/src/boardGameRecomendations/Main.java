package boardGameRecomendations;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
// This function will handle the error handling for any file errors and will create the GUI object
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("games.txt");
		
		if (file.exists()) {
			new GUI(file);
		} else {
			System.out.println("File not found");
		}
	}
}