/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrame4
 * Description: This is the fourth page of education: Common Circuit Errors.
 * Warning Buttons will go back to this page.
 */

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EducationFrame4 extends JFrame {

	// title/menu panel
	JPanel toolPanel = new JPanel();
	public JButton homeButton = new JButton("Home");
	public JButton materialButton = new JButton("Material");

	// Initializing GUI elements
	public JLabel titleLabel1 = new JLabel("Learn About Circuits:");
	public JLabel titleLabel2 = new JLabel("4, Common Circuit Errors: Short Circuit & Open Circuit ");
	public JLabel contentLabel = new JLabel(
			"<html>A short circuit happens when there is a very low resistance path that allows too"
					+ "<br> much current to flow. This can overheat wires, damage components, or drain the"
					+ "<br> battery quickly."
					+ "<br> An open circuit occurs when the path is broken, so no current can flow.\r\n");
	public ImageIcon shortCircuit = new ImageIcon("src/images/ShortCircuit.png");
	public ImageIcon brokenCircuit = new ImageIcon("src/images/BrokenCircuit.png");
	public JLabel shortCircuitLabel = new JLabel(shortCircuit);
	public JLabel brokenCircuitLabel = new JLabel(brokenCircuit);
	public JLabel noteLabel1 = new JLabel("No resistor in the path");
	public JLabel noteLabel2 = new JLabel("The wire is broken");
	public JButton lastButton = new JButton("← Last");
	public JButton nextButton = new JButton("Next →");

	// the frame
	public EducationFrame4() {

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

		titleLabel2.setBounds(60, 170, 924, 41);
		titleLabel2.setFont(new Font("Inter", Font.BOLD, 26));
		titleLabel2.setForeground(Color.BLACK);
		add(titleLabel2);

		contentLabel.setBounds(60, 190, 1066, 182);
		contentLabel.setFont(new Font("Inter", Font.PLAIN, 20));
		contentLabel.setForeground(Color.BLACK);
		add(contentLabel);

		shortCircuitLabel.setBounds(117, 340, 233, 158);
		add(shortCircuitLabel);
		brokenCircuitLabel.setBounds(490, 340, 277, 175);
		add(brokenCircuitLabel);

		noteLabel1.setBounds(117, 515, 271, 27);
		noteLabel1.setFont(new Font("Inter", Font.PLAIN, 17));
		noteLabel1.setForeground(Color.BLACK);
		add(noteLabel1);

		noteLabel2.setBounds(522, 515, 271, 27);
		noteLabel2.setFont(new Font("Inter", Font.PLAIN, 17));
		noteLabel2.setForeground(Color.BLACK);
		add(noteLabel2);

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
