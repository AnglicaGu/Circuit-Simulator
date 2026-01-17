/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: TitleFrameController
 * Description: This is the title frame that can go to 
 * education frame 1 and material chart frame
 */

package view;/*
				
				* the user to jump to the frame they wnt to use.
				*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TitleFrame extends JFrame {

	// Initializing GUI elements
	public JLabel titleLabel = new JLabel("Circuit Simulator", SwingConstants.CENTER);
	public JLabel explainLabel = new JLabel("💖Start your trip with circuits here!", SwingConstants.CENTER);
	public JButton experiButton = new JButton("Experiments");
	public JButton materialButton = new JButton("Materials");

	public TitleFrame() {

		frameSetup();

	}

	// set up the whole frame
	private void frameSetup() {

		// Initialize the frame
		setTitle("Yu's Circuit Simulator");
		setSize(1200, 600);
		setLayout(null);
		getContentPane().setBackground(Color.decode("#8baed3"));

		titleLabel.setBounds(244, 110, 741, 104);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 65));
		titleLabel.setForeground(Color.WHITE);
		add(titleLabel);

		explainLabel.setBounds(143, 237, 915, 63);
		explainLabel.setFont(new Font("Inter", Font.PLAIN | Font.ITALIC, 40));
		explainLabel.setForeground(Color.BLACK);
		add(explainLabel);

		experiButton.setBounds(162, 369, 382, 100);
		experiButton.setBackground(Color.decode("#f2c748"));
		experiButton.setForeground(Color.WHITE);
		experiButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		add(experiButton);

		materialButton.setBounds(656, 369, 382, 100);
		materialButton.setBackground(Color.decode("#f2c748"));
		materialButton.setForeground(Color.WHITE);
		materialButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		add(materialButton);

		// leaving the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

}
