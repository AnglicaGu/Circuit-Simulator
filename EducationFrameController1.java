/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrameController1
 * Description: Controller for EducationFrame1. 
 * Handles buttons.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EducationFrame1;

public class EducationFrameController1 implements ActionListener {

	EducationFrame1 edu1 = new EducationFrame1();

	// constructor
	public EducationFrameController1() {

		// add action listeners to the buttons
		edu1.homeButton.addActionListener(this);
		edu1.materialButton.addActionListener(this);
		edu1.experimentButton.addActionListener(this);
		edu1.nextButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the home button is pressed
		if (e.getSource() == edu1.homeButton) {

			// close the current frame
			edu1.dispose();
			setVisible(false);

			// open the home frame
			new TitleFrameController();

		}

		// if the material button is pressed
		else if (e.getSource() == edu1.materialButton) {

			// close the current frame
			edu1.dispose();
			setVisible(false);

			// open the material frame
			new MaterialChartController();

		}

		// if the "Build One Yourself" button is pressed
		else if (e.getSource() == edu1.experimentButton) {

			// close the current frame
			edu1.dispose();
			setVisible(false);

			// open the experiment frame
			new ExperimentController1();

		}

		// if the next button is pressed
		else if (e.getSource() == edu1.nextButton) {

			// close the current frame
			edu1.dispose();
			setVisible(false);

			// open the next frame
			new EducationFrameController2();

		}
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
