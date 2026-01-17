/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: MaterialCompareFrame
 * Description: This frame let the user choose two materials and compare
 */

package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaterialCompareFrame extends JFrame {

	public double current1 = 0;
	public double current2 = 0;

	// title/menu panel
	JPanel toolPanel = new JPanel();
	public JButton homeButton = new JButton("Home");
	public JButton experimentButton = new JButton("Experiments");

	// Initializing GUI elements
	public JLabel titleLabel = new JLabel("Comparison");
	public ImageIcon compareCircuit = new ImageIcon("src/images/Comparison.jpg");
	public JLabel compareLabel1 = new JLabel(compareCircuit);
	public JLabel compareLabel2 = new JLabel(compareCircuit);
	public JButton lastButton = new JButton("← Last");
	public JLabel selectLabel1 = new JLabel("Material of Resistor:");
	public JLabel selectLabel2 = new JLabel("Material of Resistor:");
	public String[] materials = { "- Select Material 1 -", "Silver", "Garphite", "Iron", "Wood", "PET", "Mercury",
			"Copper", "Gold", "Aluminum", "Zinc", "Sea Water", "Glass" };
	public JComboBox materialJComboBox1 = new JComboBox(materials);
	public JComboBox materialJComboBox2 = new JComboBox(materials);
	public JLabel currentLabel1 = new JLabel("Current in circuit:" + current1 + " A");
	public JLabel currentLabel2 = new JLabel("Current in circuit:" + current2 + " A");

	// the frame
	public MaterialCompareFrame() {

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

		experimentButton.setBounds(945, 0, 256, 88);
		experimentButton.setFont(new Font("Inter", Font.BOLD, 24));
		experimentButton.setBackground(Color.decode("#384766"));
		experimentButton.setForeground(Color.WHITE);
		toolPanel.add(experimentButton);

		// add the buttons onto the menu panel
		toolPanel.setBounds(0, 0, 1200, 88);
		toolPanel.setLayout(null);
		toolPanel.setBackground(Color.decode("#8baed3"));
		add(toolPanel);

		lastButton.setBounds(1052, 475, 135, 88);
		lastButton.setFont(new Font("Inter", Font.BOLD, 24));
		lastButton.setBackground(Color.decode("#384766"));
		lastButton.setForeground(Color.WHITE);
		add(lastButton);

		titleLabel.setBounds(60, 115, 1024, 48);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		titleLabel.setForeground(Color.BLACK);
		add(titleLabel);

		compareLabel1.setBounds(118, 183, 406, 258);
		add(compareLabel1);
		compareLabel2.setBounds(589, 183, 406, 258);
		add(compareLabel2);

		selectLabel1.setBounds(81, 467, 240, 26);
		selectLabel1.setFont(new Font("Inter", Font.PLAIN, 17));
		selectLabel1.setForeground(Color.BLACK);
		add(selectLabel1);

		selectLabel2.setBounds(619, 467, 240, 26);
		selectLabel2.setFont(new Font("Inter", Font.PLAIN, 17));
		selectLabel2.setForeground(Color.BLACK);
		add(selectLabel2);

		materialJComboBox1.setBounds(280, 464, 150, 31);
		add(materialJComboBox1);
		materialJComboBox2.setBounds(820, 464, 150, 31);
		add(materialJComboBox2);

		currentLabel1.setBounds(81, 500, 240, 26);
		currentLabel1.setFont(new Font("Inter", Font.PLAIN, 17));
		currentLabel1.setForeground(Color.BLACK);
		add(currentLabel1);

		currentLabel2.setBounds(619, 500, 240, 26);
		currentLabel2.setFont(new Font("Inter", Font.PLAIN, 17));
		currentLabel2.setForeground(Color.BLACK);
		add(currentLabel2);

		// leaving the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

}
