/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrameController2
 * Description: Controller for EducationFrame2. 
 * Handles buttons.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EducationFrame1;
import view.EducationFrame2;

public class EducationFrameController2 implements ActionListener {

	EducationFrame2 edu2 = new EducationFrame2();

	// constructor
	public EducationFrameController2() {

		// add action listeners to the buttons and combo boxes
		edu2.homeButton.addActionListener(this);
		edu2.materialButton.addActionListener(this);
		edu2.experimentButton.addActionListener(this);
		edu2.lastButton.addActionListener(this);
		edu2.nextButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the home button is pressed
		if (e.getSource() == edu2.homeButton) {

			// close the current frame
			edu2.dispose();
			setVisible(false);

			// open the home frame
			new TitleFrameController();

		}

		// if the material button is pressed
		else if (e.getSource() == edu2.materialButton) {

			// close the current frame
			edu2.dispose();
			setVisible(false);

			// open the material chart frame
			new MaterialChartController();

		}

		// if the "Build One Yourself" button is pressed
		else if (e.getSource() == edu2.experimentButton) {

			// close the current frame
			edu2.dispose();
			setVisible(false);

			// open the experiment frame
			new ExperimentController2();

		}

		// if the last button is pressed
		else if (e.getSource() == edu2.lastButton) {

			// close the current frame
			edu2.dispose();
			setVisible(false);

			// open the last frame
			new EducationFrameController1();

		}

		// if the next button is pressed
		else if (e.getSource() == edu2.nextButton) {

			// close the current frame
			edu2.dispose();
			setVisible(false);

			// open the next frame
			new EducationFrameController3();

		}
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
