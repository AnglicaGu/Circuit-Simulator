/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: CompareFrameController
 * Description: Controller for Material Compare frame. Handles buttons and comboboxes
 * Calculate the current and determine the brightness level
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import model.Battery;
import model.Bulb;
import model.Material;
import model.Resistor;
import view.MaterialCompareFrame;

public class CompareFrameController implements ActionListener {

	// create the view
	MaterialCompareFrame view = new MaterialCompareFrame();

	// default battery voltage
	Battery battery = new Battery("battery1", 5.0);

	// create two default bulbs
	Bulb bulb1 = new Bulb("bulb1");
	Bulb bulb2 = new Bulb("bulb2");

	// constructor
	public CompareFrameController() {

		// load the data using file reader
		new FileReader().readMaterialData();

		// add action listeners to the buttons and combo boxes
		view.homeButton.addActionListener(this);
		view.experimentButton.addActionListener(this);
		view.lastButton.addActionListener(this);
		view.materialJComboBox1.addActionListener(this);
		view.materialJComboBox2.addActionListener(this);
	}

	// enable all the buttons
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.homeButton) {
			view.dispose();
			setVisible(false);
			new TitleFrameController();
		} else if (e.getSource() == view.experimentButton) {
			view.dispose();
			setVisible(false);
			new EducationFrameController1();
		} else if (e.getSource() == view.lastButton) {
			view.dispose();
			setVisible(false);
			new MaterialChartController();
		}

		// if the user choose a material
		else if (e.getSource() == view.materialJComboBox1 || e.getSource() == view.materialJComboBox2) {

			// update the current and the brightness level of bulb
			updateCurrentsAndBrightness();
		}
	}

	// method to update the current and brightness level
	private void updateCurrentsAndBrightness() {

		// set index to record the chosen material
		int index1 = view.materialJComboBox1.getSelectedIndex() - 1;
		int index2 = view.materialJComboBox2.getSelectedIndex() - 1;

		// initialize currents
		double current1 = 0;
		double current2 = 0;

		// ------ the first circuit ------
		if (index1 >= 0 && index1 < FileReader.materialData.size()) {

			// get the material
			Material material1 = FileReader.materialData.get(index1);

			// create the resistor using the material
			Resistor resistor1 = new Resistor("R1", material1);

			// calculate resistance and current
			double totalResistance1 = resistor1.getResistance() + bulb1.getResistance();
			current1 = battery.getVoltage() / totalResistance1;

			// set the brightness of the bulb based on current
			updateBulbBrightness(current1, view.compareLabel1);
			view.current1 = current1;

			// show the current
			view.currentLabel1.setText(String.format("Current in circuit: %.3f A", current1));
		}

		// if the user don't choose the first combobox, set as default
		else {
			bulb1.setBrightnessLevel(0);
			view.currentLabel1.setText("Current in circuit: 0 A");
		}

		// ------ the second circuit ------
		if (index2 >= 0 && index2 < FileReader.materialData.size()) {

			// get the material
			Material material2 = FileReader.materialData.get(index2);

			// create the resistor using the material
			Resistor resistor2 = new Resistor("R2", material2);

			// calculate resistance and current
			double totalResistance2 = resistor2.getResistance() + bulb2.getResistance();
			current2 = battery.getVoltage() / totalResistance2;

			// set the brightness of the bulb based on current
			updateBulbBrightness(current2, view.compareLabel2);
			view.current2 = current2;

			// show the current
			view.currentLabel2.setText(String.format("Current in circuit: %.3f A", current2));
		}

		// if the user don't choose the second combobox, set as default
		else {
			bulb2.setBrightnessLevel(0);
			view.currentLabel2.setText("Current in circuit: 0 A");
		}

	}

	// determine the brightness level based on current
	private void updateBulbBrightness(double current, javax.swing.JLabel label) {

		// variable to record the brightness level
		int brightnessLevel;

		// level 0: off
		if (current < 0.1)
			brightnessLevel = 0;

		// level 1: dim
		else if (current < 0.49999)
			brightnessLevel = 1;

		// level 2: bright
		else
			brightnessLevel = 2;

		// set the icon based on brightness level
		if (brightnessLevel == 0)
			label.setIcon(new ImageIcon("src/images/bulb_off.jpg"));
		else if (brightnessLevel == 1)
			label.setIcon(new ImageIcon("src/images/bulb_dim.png"));
		else
			label.setIcon(new ImageIcon("src/images/bulb_bright.png"));
	}

	// method to set visability
	private void setVisible(boolean b) {

	}
}
