package boardGameRecomendations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ListBoardGames {
	private static ArrayList<BoardGame> _games = new ArrayList<BoardGame>();
	
	public ListBoardGames(File file) throws FileNotFoundException {
		readFile(file);
	}
	
	public static void readFile(File file) throws FileNotFoundException{
		try (Scanner scan = new Scanner(file)) {
			while(scan.hasNextLine()) {
				splicetoArray(scan.nextLine());
			}
		}
}
	
	public static void splicetoArray(String line) {
		String[] parts = line.split(",");
		List<String> genres = Arrays.asList(parts[3].split("\\|"));
		_games.add(new BoardGame(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), genres));
				
	}
	
	public static ArrayList<BoardGame> FilterbyGenre(String genre){
		ArrayList<BoardGame> filtered = new ArrayList<BoardGame>();
		
		for (BoardGame game: _games) {
			if (game.getGenres().contains(genre)) {
				filtered.add(game);
			}
		}
		return filtered;
	}
}
