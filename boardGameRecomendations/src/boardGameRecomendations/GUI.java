package boardGameRecomendations;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
		games = new ListBoardGames(file);
		
		frame = new JFrame();
		frame.setTitle("Board Game Recommendations");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setMinimumSize(new Dimension(400,400));
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);

		
		button = new JButton("Recommend Some Games");
		button.addActionListener(this);
		

		
		combo = new JComboBox<String>(genres);
		JPanel wrapper = new JPanel();
		JLabel comboLabel = new JLabel("Choose a genre of game:");
		wrapper.add(comboLabel);
		wrapper.add(combo);

		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setBackground(Color.GRAY);
		frame.add(panel, BorderLayout.WEST);
//		panel.setLayout(new GridLayout(0, 1));
		
		label = new JLabel("");
		label.setBounds(200, 200, 200, 200);
		panel.add(label);
		frame.add(wrapper, BorderLayout.EAST);
		frame.add(button, BorderLayout.SOUTH);


		


		frame.pack();
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String genre = combo.getSelectedItem().toString();
		ArrayList<BoardGame> filteredGames = ListBoardGames.FilterbyGenre(genre);
		String panelText = "<html>";
		for (BoardGame game: filteredGames) {
			panelText = panelText + game.getName() + "<br>";
		}
		panelText = panelText + "</html>";
		label.setText(panelText);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sans-serif", Font.BOLD, 12));
	}
}
