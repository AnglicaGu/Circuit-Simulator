/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: ExpermientFrame3
 * Description:  This is the combination circuit experiment.
 * It allows the user to place components into fixed slot positions.
 * The panel draws all valid slots and the components placed inside them.
 */

package view;

import model.Component;
import model.GridCell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExperimentFrame3 extends JFrame {

	// title/menu panel
	public JPanel toolPanel = new JPanel();
	public JButton homeButton = new JButton("Home");
	public JButton materialButton = new JButton("Materials");

	// first type warning panel: open circuit
	public JPanel warningPanel1 = new JPanel();
	public JButton warningButton1 = new JButton("!!! WARNING");
	public JLabel warningLabel1 = new JLabel("<html>The circuit is not" + "<br> complete!</html>",
			SwingConstants.CENTER);

	// second type warning panel: short circuit
	public JPanel warningPanel2 = new JPanel();
	public JButton warningButton2 = new JButton("!!! WARNING");
	public JLabel warningLabel2 = new JLabel("<html>The circuit is a" + "<br> short circuit!</html>",
			SwingConstants.CENTER);

	// third type warning panel: valid circuit
	public JPanel readyPanel = new JPanel();
	public JButton readyButton = new JButton("READY");
	public JLabel readyLabel = new JLabel("<html>The circuit is" + "<br> running well!</html>", SwingConstants.CENTER);

	// components panel: At the bottom and shows all the components
	public JPanel componentsPanel = new JPanel();
	public JLabel componentsLabel = new JLabel("Components:", SwingConstants.CENTER);
	public ImageIcon[] componentsIcons = { new ImageIcon("src/images/Battery.png"),
			new ImageIcon("src/images/Bulb.png"), new ImageIcon("src/images/Switch.png"),
			new ImageIcon("src/images/Resistor.png"), new ImageIcon("src/images/Buzzer.png"),
			new ImageIcon("src/images/Wire.png") };
	public JLabel[] componentsImageLabel = { new JLabel(componentsIcons[0]), new JLabel(componentsIcons[1]),
			new JLabel(componentsIcons[2]), new JLabel(componentsIcons[3]), new JLabel(componentsIcons[4]),
			new JLabel(componentsIcons[5]) };;
	public JLabel[] componentsNameLabel = { new JLabel("Battery"), new JLabel("Bulb"), new JLabel("Switch"),
			new JLabel("Resistor"), new JLabel("Buzzer"), new JLabel("Wire") };

	// paint panel (used to draw grids)
	public PaintPanel paintPanel = new PaintPanel();

	// the frame
	public ExperimentFrame3() {
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

		// ------ WARNING PANEL 1 ------
		warningButton1.setBounds(29, 13, 161, 32);
		warningButton1.setForeground(Color.BLACK);
		warningButton1.setBackground(Color.YELLOW);
		warningButton1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		warningPanel1.add(warningButton1);

		warningLabel1.setBounds(11, 57, 202, 48);
		warningLabel1.setFont(new Font("Inter", Font.PLAIN, 17));
		warningLabel1.setForeground(Color.BLACK);
		warningPanel1.add(warningLabel1);

		warningPanel1.setLayout(null);
		warningPanel1.setBounds(880, 193, 224, 118);
		warningPanel1.setBackground(Color.decode("#d97652"));
		add(warningPanel1);

		// ------ WARNING PANEL 2 ------
		warningButton2.setBounds(29, 13, 161, 32);
		warningButton2.setForeground(Color.BLACK);
		warningButton2.setBackground(Color.YELLOW);
		warningButton2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		warningPanel2.add(warningButton2);

		warningLabel2.setBounds(11, 57, 202, 48);
		warningLabel2.setFont(new Font("Inter", Font.PLAIN, 17));
		warningLabel2.setForeground(Color.BLACK);
		warningPanel2.add(warningLabel2);

		warningPanel2.setLayout(null);
		warningPanel2.setBounds(880, 193, 224, 118);
		warningPanel2.setBackground(Color.decode("#faa642"));
		add(warningPanel2);

		// ------ READY PANEL ------
		readyButton.setBounds(29, 13, 161, 32);
		readyButton.setForeground(Color.WHITE);
		readyButton.setBackground(Color.GREEN);
		readyButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		readyPanel.add(readyButton);

		readyLabel.setBounds(11, 57, 202, 48);
		readyLabel.setFont(new Font("Inter", Font.PLAIN, 17));
		readyLabel.setForeground(Color.BLACK);
		readyPanel.add(readyLabel);

		readyPanel.setLayout(null);
		readyPanel.setBounds(880, 193, 224, 118);
		readyPanel.setBackground(Color.decode("#ccefb3"));
		add(readyPanel);

		// ------ COMPONENTS PANEL ------
		componentsLabel.setBounds(0, 10, 143, 21);
		componentsLabel.setFont(new Font("Inter", Font.PLAIN, 13));
		componentsLabel.setForeground(Color.BLACK);
		componentsPanel.add(componentsLabel);

		componentsImageLabel[0].setBounds(85, 40, 106, 52);
		componentsImageLabel[1].setBounds(280, 40, 106, 52);
		componentsImageLabel[2].setBounds(482, 40, 106, 52);
		componentsImageLabel[3].setBounds(692, 40, 106, 52);
		componentsImageLabel[4].setBounds(904, 27, 69, 69);
		componentsImageLabel[5].setBounds(1055, 40, 106, 52);

		componentsNameLabel[0].setBounds(113, 90, 162, 21);
		componentsNameLabel[1].setBounds(323, 90, 162, 21);
		componentsNameLabel[2].setBounds(522, 90, 162, 21);
		componentsNameLabel[3].setBounds(725, 90, 162, 21);
		componentsNameLabel[4].setBounds(918, 90, 162, 21);
		componentsNameLabel[5].setBounds(1086, 90, 162, 21);

		// add the labels onto the components panel
		for (int i = 0; i < 6; i++) {
			componentsPanel.add(componentsImageLabel[i]);
			componentsPanel.add(componentsNameLabel[i]);
			componentsNameLabel[i].setFont(new Font("Inter", Font.PLAIN, 13));
			componentsNameLabel[i].setForeground(Color.BLACK);
		}

		componentsPanel.setLayout(null);
		componentsPanel.setBounds(0, 445, 1200, 155);
		componentsPanel.setBackground(Color.decode("#f6e09f"));
		add(componentsPanel);

		// ------ PAINT PANEL ------
		paintPanel.setBounds(70, 130, 740, 310);
		paintPanel.setBackground(Color.WHITE);
		paintPanel.setLayout(null);
		add(paintPanel);

		// Initailly, only show warning panel 1 (open circuit)
		warningPanel1.setVisible(true);
		warningPanel2.setVisible(false);
		readyPanel.setVisible(false);

		// leaving the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	// Method to close the frame
	public void endFrame() {
		this.dispose();
	}

	// Custom the paint panel that draws fixed component slots
	// and their components
	public class PaintPanel extends JPanel {
		private List<GridCell> componentSlots;
		private Image backgroundImage;

		public PaintPanel() {
			componentSlots = new ArrayList<>();

			// load the background picture
			backgroundImage = new ImageIcon("src/images/background3.png").getImage();

			// set the position for the slots
			componentSlots.add(new GridCell(120, 80));
			componentSlots.add(new GridCell(120, 200));
			componentSlots.add(new GridCell(300, 40));
			componentSlots.add(new GridCell(300, 240));
			componentSlots.add(new GridCell(480, 80));
			componentSlots.add(new GridCell(480, 200));
			componentSlots.add(new GridCell(660, 80));
			componentSlots.add(new GridCell(660, 200));
		}

		// Store the slots as an list of GridCell (each can put in components)
		public List<GridCell> getComponentSlots() {
			return componentSlots;
		}

		// Override the paintComponent method
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			// Draw the background image
			if (backgroundImage != null) {
				g.drawImage(backgroundImage, 95, 20, 580, 240, this);
			}

			// Draw the grids
			for (GridCell cell : componentSlots) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(cell.getRow() - 54, cell.getCol() - 39, 108, 78);

				// Draw the component if the gird is not empty
				if (!cell.isEmpty()) {
					
					// Get the imageIcon of the component
					ImageIcon icon = cell.getComponent().getIcon();
					
					// Draw the image
					g.drawImage(icon.getImage(), cell.getRow() - 35, cell.getCol() - 15, 70, 30, this);
				}
			}
		}
	}

}
