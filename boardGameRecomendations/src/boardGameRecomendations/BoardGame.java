package boardGameRecomendations;

import java.util.List;

public class BoardGame {
//	This class will be the template to store the data for each game
//	This class will have getters to allow easy access to necessary data
	private String _name;
	private int _minPlayer;
	private int _maxPlayer;
	private List<String> _genres;
	
	public BoardGame(String name, int minPlayer, int maxPlayer, List<String> genres) {
//		Initialize the object and assign the data for each game
		_name = name;
		_minPlayer = minPlayer;
		_maxPlayer = maxPlayer;
		_genres = genres;
	}
	
	public String getName() {
		return _name;
	}
	
	public String getPlayers() {
		String players = "max " + _maxPlayer + " players";
		return players;
	}
	
	public List<String> getGenres() {
		return _genres;
	}

}
