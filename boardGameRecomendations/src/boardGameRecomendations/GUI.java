package boardGameRecomendations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	private static JFrame frame;
	private static JButton button;
	private static JLabel label;
	private static JPanel panel;
	private static JComboBox<String> combo;
	private static String[] genres = {"family", "nature", "cooperative", "competitive", "historical", "party", "dexterity", "fantasy", "multi-player", "two-player"};
	private static ListBoardGames games;
	
	public GUI(File file) throws FileNotFoundException {
//		This GUI function takes a given file that contains board games with information
//		about player count and genre type and populates them into a graphical user 
//		interface that allows users to get board game recommendations given a specified
//		genre
		
		
		games = new ListBoardGames(file);
		
//		Create the GUI using swing
		
//		create the frame
		frame = new JFrame();
		frame.setTitle("Board Game Recommendations");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setMinimumSize(new Dimension(400,400));
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		
//		create the button and call the action listener
		button = new JButton("Recommend Some Games");
		button.addActionListener(this);
		frame.add(button, BorderLayout.SOUTH);
		
//		create the drop down box to choose an available genre and set that in a
//		wrapper to place the label above the box
		combo = new JComboBox<String>(genres);
		JPanel wrapper = new JPanel();
		wrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel comboLabel = new JLabel("Choose a genre of game:");
		wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
		comboLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        combo.setAlignmentX(Component.CENTER_ALIGNMENT);
		wrapper.add(comboLabel);
		wrapper.add(Box.createRigidArea(new Dimension(0, 5)));
		wrapper.add(combo);
		frame.add(wrapper, BorderLayout.EAST);


//		create the panel to display the recommended games
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setBackground(Color.GRAY);
		frame.add(panel, BorderLayout.WEST);
		
		label = new JLabel("");
		label.setMinimumSize(new Dimension(500, 600));
		label.setPreferredSize(new Dimension(500, 600));
		label.setMaximumSize(new Dimension(500, 600));
		panel.add(label);

//		display the window
		frame.pack();
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
//		get the selected genre, filter the games based on the genre, and format the 
//		string to display in the window
		String genre = combo.getSelectedItem().toString();
		ArrayList<BoardGame> filteredGames = ListBoardGames.FilterbyGenre(genre);
		String panelText = "";
		for (BoardGame game: filteredGames) {
			panelText = panelText + game.getName() + " - " + game.getPlayers() + "<br>";
		}
//		Divide the panel text into two columns to fit in the frame properly
//		Split the entire string apart and divide it between the columns
		String[] phrases = panelText.split(">");
//		Create string builders to store the separate columns
		StringBuilder col1 = new StringBuilder();
		StringBuilder col2 = new StringBuilder();
		
//		put each half of the phrases in their respective columns
		for (int i = 0; i < phrases.length; i++) {
			if (i < phrases.length / 2) {
				col1.append(phrases[i]).append(">");
			} else {
				col2.append(phrases[i]).append(">");
			}
		}
		
//		format the columns using HTML
		String htmlText = String.format(
				"<html><table width = '100%%'><tr><td width = '50%%'>%s</td><td width = '50%%'>%s</td></tr></table></html>",
				col1.toString().trim(),
				col2.toString().trim()
				);
		label.setText(htmlText);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sans-serif", Font.BOLD, 12));
	}
}
