/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: ExperimentController1
 * Description: Controller for ExperimentFrame1. Handles buttons, dragging
 * placing and check the circuit every time a new action is detected.
 */

package controller;

import model.*;
import model.Component;
import view.ExperimentFrame1;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.List;

public class ExperimentController1 implements ActionListener {

	// create the view
	private ExperimentFrame1 frame;

	// set a variable to store the situation of the circuit
	// 1=open circuit, 2=short circuit, 3=valid, 4=missing battery
	private int situation = 0;

	// store the audio of the buzzer
	private AudioClip buzzerClip = null;

	// constructor
	public ExperimentController1() {

		// view
		frame = new ExperimentFrame1();

		// ActionListeners for the buttons
		frame.homeButton.addActionListener(this);
		frame.materialButton.addActionListener(this);
		frame.warningButton1.addActionListener(this);
		frame.warningButton2.addActionListener(this);
		frame.readyButton.addActionListener(this);

		// set actionListener in component icon
		// loop through all the icons
		for (int i = 0; i < frame.componentsImageLabel.length; i++) {

			final int index = i;
			JLabel sourceLabel = frame.componentsImageLabel[i];

			// add actionListener
			sourceLabel.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					ImageIcon icon = (ImageIcon) sourceLabel.getIcon();
					JLabel dragLabel = new JLabel(icon);

					// set a drag label so the icon can move with the mouse
					dragLabel.setSize(40, 40);
					frame.getLayeredPane().add(dragLabel, JLayeredPane.DRAG_LAYER);

					// get the point the mouse is in
					Point offset = e.getPoint();

					sourceLabel.addMouseMotionListener(new MouseMotionAdapter() {

						// get the point the user drag from
						public void mouseDragged(MouseEvent e) {
							Point newLoc = SwingUtilities.convertPoint(sourceLabel, e.getPoint(),
									frame.getLayeredPane());

							// place the icon with the mouse
							dragLabel.setLocation(newLoc.x - offset.x, newLoc.y - offset.y);
						}
					});

					sourceLabel.addMouseListener(new MouseAdapter() {

						// get the point the user releases
						public void mouseReleased(MouseEvent e) {

							// decide which gird the component should go in
							Point releasePoint = SwingUtilities.convertPoint(sourceLabel, e.getPoint(),
									frame.paintPanel);
							placeComponentAt(index, releasePoint);
							frame.getLayeredPane().remove(dragLabel);
							frame.getLayeredPane().repaint();
						}
					});
				}
			});
		}

		// make the switch clickable
		frame.paintPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point clicked = e.getPoint();
				List<GridCell> slots = frame.paintPanel.getComponentSlots();

				// loop through every grid
				for (GridCell cell : slots) {

					// set bound to detect click in the grids
					Rectangle bounds = new Rectangle(cell.getRow() - 54, cell.getCol() - 30, 109, 61);

					// if the user click a grid with switch in it
					if (bounds.contains(clicked) && !cell.isEmpty() && cell.getComponent() instanceof Switch sw) {

						// toggle the switch
						sw.toggle();

						// repaint the switch to closed image
						frame.paintPanel.repaint();

						// check the circuit again when the switch is clicked
						validCircuit();
						break;
					}
				}
			}
		});
	}

	// method to place the component
	private void placeComponentAt(int componentIndex, Point p) {
		List<GridCell> slots = frame.paintPanel.getComponentSlots();

		// loop through all the slots
		for (GridCell cell : slots) {

			// set bound in each grid
			Rectangle bounds = new Rectangle(cell.getRow() - 54, cell.getCol() - 30, 109, 61);

			// if the mouse is relaesed here
			if (bounds.contains(p)) {

				// create a component
				Component component = createComponent(componentIndex);
				if (component != null) {

					// set the component in the grid
					cell.setComponent(component);

					// repaint the panel and put icon in
					frame.paintPanel.repaint();

					// check the circuit again when every new component is put in
					validCircuit();
				}
				break;
			}
		}
	}

	// create the correct component
	private Component createComponent(int index) {

		// set an id to tell the same type of components
		// e.g. Bulb "C1" and Bulb "C2"
		String id = "C" + System.currentTimeMillis();

		// return the component based on the index of icon clicked
		return switch (index) {
		case 0 -> new Battery(id);
		case 1 -> new Bulb(id);
		case 2 -> new Switch(id);
		// default material for resistor is copper
		case 3 -> new Resistor(id, new Material("Copper", 59600000));
		case 4 -> new Buzzer(id);
		case 5 -> new Wire(id);
		default -> null;
		};
	}

	// check the validation of the circuit
	private void validCircuit() {

		// get all the grids (to know the components inside)
		List<GridCell> slots = frame.paintPanel.getComponentSlots();

		// create varaibles needed in check
		double totalResistance = 0.0;
		boolean hasEmpty = false;
		boolean hasBattery = false;
		boolean allSwitchesOn = true;

		// loop through all the grids
		for (GridCell cell : slots) {

			// check if there is an empty slot
			if (cell.isEmpty()) {
				hasEmpty = true;
				break;
			}

			// if all filled
			else {

				// calculate total resistance
				Component comp = cell.getComponent();
				totalResistance += comp.getResistance();

				// check if there is a battery
				if (comp instanceof Battery) {
					hasBattery = true;
				}

				// check is there open switches
				if (comp instanceof Switch sw) {
					if (!sw.getIsOn()) {
						allSwitchesOn = false;
					}
				}
			}
		}

		// if there is an empty slot, situation is 1: open circuit
		if (hasEmpty) {
			situation = 1;

			// no buzzer and bulbs working
			stopBuzzer();
			restoreBulbs();

			// show warning panel 1
			showPanel(1);
			return;
		}

		// if there is an open switch, situation is 1: open circuit
		if (!allSwitchesOn) {
			situation = 1;
			stopBuzzer();
			restoreBulbs();

			// show warning panel 1
			showPanel(1);
			return;
		}

		// if there is no battery, situation is 4: missing battery
		if (!hasBattery) {
			situation = 4;
			stopBuzzer();
			restoreBulbs();

			// give the user a message
			JOptionPane.showMessageDialog(frame, "Please put at least one battery!", "Missing Battery",
					JOptionPane.WARNING_MESSAGE);

			// show warning panel 1
			showPanel(1);
			return;
		}

		// calculate the current based on resistance
		double current = totalResistance > 0 ? 5.0 / totalResistance : Double.POSITIVE_INFINITY;

		// if total resistance is too big and current is too small
		// situation is 1: open circuit
		// *I give an open circuit rlly big resistance
		if (totalResistance >= 1000 || current < 0.01) {
			situation = 1;
			stopBuzzer();
			restoreBulbs();

			// show warning panel 1
			showPanel(1);
		}

		// if taotal resistance too small
		// situation is 2: short circuit
		else if (totalResistance < 0.1) {
			situation = 2;

			// no bulbs and buzzers working
			stopBuzzer();
			restoreBulbs();

			// show warning panel 2
			showPanel(2);
		}

		// if all corrent, situation is 3: valid circuit
		else {
			situation = 3;

			// show ready panel
			showPanel(3);

			// set the bulbs bright and buzzers making sound
			// loop through all slots
			for (GridCell cell : slots) {
				Component comp = cell.getComponent();

				// find bulbs and change icon to bright one
				if (comp instanceof Bulb bulb) {
					bulb.setIcon(new ImageIcon("src/images/bulb_on.png"));
				}

				// find buzzers and play the sound
				if (comp instanceof Buzzer) {
					playBuzzer();
				}
			}
		}

		// repaint the panel with new icons
		frame.paintPanel.repaint();
	}

	// method to turn off the bulbs
	private void restoreBulbs() {
		for (GridCell cell : frame.paintPanel.getComponentSlots()) {

			// set the icon back to no light
			if (!cell.isEmpty() && cell.getComponent() instanceof Bulb bulb) {
				bulb.setIcon(new ImageIcon("src/images/Bulb.png"));
			}
		}
	}

	// method to play the buzzer
	private void playBuzzer() {

		// try to read the wav file
		try {
			if (buzzerClip == null) {
				buzzerClip = java.applet.Applet.newAudioClip(new URL("file:src/sound/buzzer.wav"));
			}
			buzzerClip.loop();
		}

		// print the trace if there is exception
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// method to stop the buzzer
	private void stopBuzzer() {
		if (buzzerClip != null) {
			buzzerClip.stop();
		}
	}

	// method to show the correct panel
	private void showPanel(int situation) {

		// set the correct index visible
		frame.warningPanel1.setVisible(situation == 1);
		frame.warningPanel2.setVisible(situation == 2);
		frame.readyPanel.setVisible(situation == 3);
	}

	// enable all the buttons
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == frame.homeButton) {
			frame.dispose();
			setVisible(false);
			new TitleFrameController();
		} else if (e.getSource() == frame.materialButton) {
			frame.dispose();
			setVisible(false);
			new MaterialChartController();
		} else if (e.getSource() == frame.warningButton1) {
			frame.dispose();
			setVisible(false);
			new EducationFrameController4();
		} else if (e.getSource() == frame.warningButton2) {
			frame.dispose();
			setVisible(false);
			new EducationFrameController4();
		} else if (e.getSource() == frame.readyButton) {

			// stop the buzzer before closing the frame
			List<GridCell> slots = frame.paintPanel.getComponentSlots();

			// loop through all the slots
			for (GridCell cell : slots) {
				Component comp = cell.getComponent();

				// find buzzers and stop the sound
				if (comp instanceof Buzzer) {
					stopBuzzer();
				}
			}

			frame.dispose();
			setVisible(false);
			new EducationFrameController1();
		}
	}

	// method to set visibility
	private void setVisible(boolean b) {
	}
}
