package boardGameRecomendations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadGameFile {
	
	public static void readFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
