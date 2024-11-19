package boardGameRecomendations;

import java.util.List;

public class BoardGame {
	private String _name;
	private int _minPlayer;
	private int _maxPlayer;
	private List<String> _genres;
	
	public BoardGame(String name, int minPlayer, int maxPlayer, List<String> genres) {
		_name = name;
		_minPlayer = minPlayer;
		_maxPlayer = maxPlayer;
		_genres = genres;
	}
	
	public String getName() {
		return _name;
	}
	
	public String getPlayers() {
		String players = "Min: " + _minPlayer + ", Max: " + _maxPlayer;
		return players;
	}
	
	public List<String> getGenres() {
		return _genres;
	}

}
