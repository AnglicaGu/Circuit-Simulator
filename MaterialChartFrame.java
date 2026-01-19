/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: MaterialChartFrame
 * Description:  This is the frame for the chart of electrical conductivity.
 */


package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaterialChartFrame extends JFrame{
	
			// title/menu panel
			JPanel toolPanel = new JPanel();
			public JButton homeButton = new JButton("Home");
			public JButton experimentButton = new JButton("Experiments");

			// Initializing GUI elements
			public JLabel titleLabel = new JLabel("Electrical Conductivity of Different Materials");
			public JButton nextButton = new JButton("Next →");
			
			// chart panel
			public JPanel chartPanel = new JPanel();

			//the frame
			public MaterialChartFrame() {

				frameSetup();

			}

			// set up the whole frame
			private void frameSetup() {

				//Initialize the frame
				setTitle("Yu's Circuit Simulator");
				setSize(1200, 600);
				setLayout(null);
				getContentPane().setBackground(Color.WHITE);

				// ------ TOOL PANEL ------
				homeButton.setBounds(0, 0,227, 88);
				homeButton.setFont(new Font("Inter", Font.BOLD, 24));
				homeButton.setBackground(Color.decode("#384766"));
				homeButton.setForeground(Color.WHITE);
				toolPanel.add(homeButton);
				
				experimentButton.setBounds(945,0,256, 88);
				experimentButton.setFont(new Font("Inter", Font.BOLD, 24));
				experimentButton.setBackground(Color.decode("#384766"));
				experimentButton.setForeground(Color.WHITE);
				toolPanel.add(experimentButton);

				// add the buttons onto the menu panel
				toolPanel.setBounds(0, 0, 1200, 88);
				toolPanel.setLayout(null);
				toolPanel.setBackground(Color.decode("#8baed3"));
				add(toolPanel);
				
				nextButton.setBounds(1052, 475,135, 88);
				nextButton.setFont(new Font("Inter", Font.BOLD, 24));
				nextButton.setBackground(Color.decode("#384766"));
				nextButton.setForeground(Color.WHITE);
				add(nextButton);

				titleLabel.setBounds(60, 115, 1024, 48);
				titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
				titleLabel.setForeground(Color.BLACK);
				add(titleLabel);
				
				// ------ CHART PANEL ------
				chartPanel.setLayout(null);
				chartPanel.setBounds(60, 180, 879, 350);
				chartPanel.setBackground(Color.LIGHT_GRAY);
				add(chartPanel);

				// leaving the frame
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setResizable(false);
				setVisible(true);

			}
			
			// the method to set put the chart panel into continer
			public void setChartPanel(JPanel panel) {

				// clear the previous chart
				chartPanel.removeAll();

				// add a new chart
				chartPanel.add(panel);

				// revalidate
				chartPanel.revalidate();
				chartPanel.repaint();
			}
}
