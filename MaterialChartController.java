/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Material Chart Controller
 * Description: Controller for material chart frame
 */

package controller;

import org.jfree.chart.ChartPanel;

import view.MaterialChartFrame;
import view.MaterialChartGenerator;
import controller.CompareFrameController;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class MaterialChartController implements ActionListener {

	// the view
	MaterialChartFrame view = new MaterialChartFrame();

	// constructor
	public MaterialChartController() {

		// ActionListeners for the restrictions
		view.homeButton.addActionListener(this);
		view.experimentButton.addActionListener(this);
		view.nextButton.addActionListener(this);

		// load the file and initialize materialData
		FileReader fileReader = new FileReader();
		fileReader.readMaterialData();

		// create the chartPanel
		ChartPanel chartPanel = null;

		// generate the chart
		chartPanel = MaterialChartGenerator.drawConductivityBarChart(FileReader.materialData);
		view.setChartPanel(chartPanel);
	}

	// enable all the buttons
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.homeButton) {

			// close the current frame
			view.dispose();
			setVisible(false);

			// open the home frame
			new TitleFrameController();

		}

		// if the map button is pressed
		else if (e.getSource() == view.experimentButton) {

			// close the current frame
			view.dispose();
			setVisible(false);

			// open the map frame
			new EducationFrameController1();

		}

		// if the map button is pressed
		else if (e.getSource() == view.nextButton) {

			// close the current frame
			view.dispose();
			setVisible(false);

			// open the map frame
			new CompareFrameController();

		}
	}

	// method to set visibility
	private void setVisible(boolean b) {

	}
}