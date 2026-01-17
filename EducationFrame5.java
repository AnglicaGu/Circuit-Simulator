/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrame5
 * Description: This is the fifth page of education: Basic Circuit Calculations.
 */

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EducationFrame5 extends JFrame {

	// title/menu panel
	JPanel toolPanel = new JPanel();
	public JButton homeButton = new JButton("Home");
	public JButton materialButton = new JButton("Material");

	// Initializing GUI elements
	public JLabel titleLabel1 = new JLabel("Learn About Circuits:");
	public JLabel titleLabel2 = new JLabel("5, Basic Calculation");
	public JLabel contentLabel = new JLabel("<html>Ohm’s Law is the foundation" + "<br> of all circuit calculations:"
			+ "<br> V = I × R" + "<br> From this formula, you can" + "<br> derive:" + "<br> ·I = V / R"
			+ "<br> ·R = V / I</html>");
	public ImageIcon calculation = new ImageIcon("src/images/calculation.png");
	public JLabel gifLabel = new JLabel(calculation);
	public JButton lastButton = new JButton("← Last");

	// the frame
	public EducationFrame5() {

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

		// add the buttons onto the menu panel
		toolPanel.setBounds(0, 0, 1200, 88);
		toolPanel.setLayout(null);
		toolPanel.setBackground(Color.decode("#8baed3"));
		add(toolPanel);

		// ------ COTENTS ------
		titleLabel1.setBounds(60, 112, 568, 48);
		titleLabel1.setFont(new Font("Inter", Font.BOLD, 30));
		titleLabel1.setForeground(Color.BLACK);
		add(titleLabel1);

		titleLabel2.setBounds(60, 180, 331, 41);
		titleLabel2.setFont(new Font("Inter", Font.BOLD, 26));
		titleLabel2.setForeground(Color.BLACK);
		add(titleLabel2);

		contentLabel.setBounds(60, 210, 385, 291);
		contentLabel.setFont(new Font("Inter", Font.PLAIN, 24));
		contentLabel.setForeground(Color.BLACK);
		add(contentLabel);

		gifLabel.setBounds(458, 134, 500, 407);
		add(gifLabel);

		lastButton.setBounds(1052, 475, 135, 88);
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
