package boardGameRecomendations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ListBoardGames {
//	This class will initialize the list of games by taking the game file and 
//	creating a board game object for each line
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
//		split the line apart by the specified format and call the BoardGame initializer
		String[] parts = line.split(",");
		List<String> genres = Arrays.asList(parts[3].split("\\|"));
		_games.add(new BoardGame(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), genres));
				
	}
	
	public static ArrayList<BoardGame> FilterbyGenre(String genre){
//		filter the array of board games by iterating through each game and checking if 
//		the genre exists in their list of genres
		ArrayList<BoardGame> filtered = new ArrayList<BoardGame>();
		
		for (BoardGame game: _games) {
			if (game.getGenres().contains(genre)) {
				filtered.add(game);
			}
		}
		return filtered;
	}
}
