/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrame3
 * Description: This is the third page of education: Combination Circuit.
 * It can lead to the experiment frame of combination circuit.
 */

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EducationFrame3 extends JFrame {
	
	// title/menu panel
	JPanel toolPanel = new JPanel();
	public JButton homeButton = new JButton("Home");
	public JButton materialButton = new JButton("Material");

	// Initializing GUI elements
	public JLabel titleLabel1 = new JLabel("Learn About Circuits:");
	public JLabel titleLabel2 = new JLabel("3, Combination Circuits");
	public JLabel contentLabel = new JLabel("<html>A combination circuit (also called a series-"
			+ "<br> parallel circuit) includes parts that are"
			+ "<br> connected in series and others in parallel. These"
			+ "<br> circuits are common in more complex systems" + "<br> and require step-by-step analysis.</html>");
	public JButton experimentButton = new JButton("Build One Yourself");
	public ImageIcon seriesCircuit = new ImageIcon("src/images/Combine.gif");
	public JLabel gifLabel = new JLabel(seriesCircuit);
	public JLabel noteLabel = new JLabel(
			"<html>A and B are independent of each other " + "<br>and both are related to C and D</html>");
	public JButton lastButton = new JButton("← Last");
	public JButton nextButton = new JButton("Next →");

	// the frame
	public EducationFrame3() {

		frameSetup();

	}

	// set up the whole frame
	private void frameSetup() {

		// Initialize the frame
		setTitle("Yu's Circuit Simulator");
		setSize(1200, 600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		// ------ TOOL PANEL ------
		homeButton.setBounds(0, 0, 227, 88);
		homeButton.setFont(new Font("Inter", Font.BOLD, 24));
		homeButton.setBackground(Color.decode("#384766"));
		homeButton.setForeground(Color.WHITE);
		toolPanel.add(homeButton);

		materialButton.setBounds(945, 0, 256, 88);
		materialButton.setFont(new Font("Inter", Font.BOLD, 24));
		materialButton.setBackground(Color.decode("#384766"));
		materialButton.setForeground(Color.WHITE);
		toolPanel.add(materialButton);

		// add the buttons onto the tool panel
		toolPanel.setBounds(0, 0, 1200, 88);
		toolPanel.setLayout(null);
		toolPanel.setBackground(Color.decode("#8baed3"));
		add(toolPanel);

		// ------ COTENTS ------
		titleLabel1.setBounds(60, 112, 568, 48);
		titleLabel1.setFont(new Font("Inter", Font.BOLD, 30));
		titleLabel1.setForeground(Color.BLACK);
		add(titleLabel1);

		titleLabel2.setBounds(60, 183, 340, 41);
		titleLabel2.setFont(new Font("Inter", Font.BOLD, 26));
		titleLabel2.setForeground(Color.BLACK);
		add(titleLabel2);

		contentLabel.setBounds(60, 233, 622, 180);
		contentLabel.setFont(new Font("Inter", Font.PLAIN, 26));
		contentLabel.setForeground(Color.BLACK);
		add(contentLabel);

		experimentButton.setBounds(97, 452, 400, 88);
		experimentButton.setBackground(Color.decode("#f2c748"));
		experimentButton.setForeground(Color.WHITE);
		experimentButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		add(experimentButton);

		gifLabel.setBounds(700, 150, 391, 229);
		add(gifLabel);

		noteLabel.setBounds(750, 380, 450, 58);
		noteLabel.setFont(new Font("Inter", Font.PLAIN, 20));
		noteLabel.setForeground(Color.BLACK);
		add(noteLabel);

		nextButton.setBounds(1052, 475, 135, 88);
		nextButton.setFont(new Font("Inter", Font.BOLD, 24));
		nextButton.setBackground(Color.decode("#384766"));
		nextButton.setForeground(Color.WHITE);
		add(nextButton);

		lastButton.setBounds(917, 475, 135, 88);
		lastButton.setFont(new Font("Inter", Font.BOLD, 24));
		lastButton.setBackground(Color.decode("#384766"));
		lastButton.setForeground(Color.WHITE);
		add(lastButton);

		// leaving the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}
}
