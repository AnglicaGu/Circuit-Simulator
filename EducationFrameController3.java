/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrameController3
 * Description: Controller for EducationFrame3. 
 * Handles buttons.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EducationFrame1;
import view.EducationFrame2;
import view.EducationFrame3;

public class EducationFrameController3 implements ActionListener {

	EducationFrame3 edu3 = new EducationFrame3();

	// constructor
	public EducationFrameController3() {

		// add action listeners to the buttons
		edu3.homeButton.addActionListener(this);
		edu3.materialButton.addActionListener(this);
		edu3.experimentButton.addActionListener(this);
		edu3.lastButton.addActionListener(this);
		edu3.nextButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the home button is pressed
		if (e.getSource() == edu3.homeButton) {

			// close the current frame
			edu3.dispose();
			setVisible(false);

			// open the title frame
			new TitleFrameController();

		}

		// if the material button is pressed
		else if (e.getSource() == edu3.materialButton) {

			// close the current frame
			edu3.dispose();
			setVisible(false);

			// open the material chart frame
			new MaterialChartController();

		}

		// if the "Build one yourself" button is pressed
		else if (e.getSource() == edu3.experimentButton) {

			// close the current frame
			edu3.dispose();
			setVisible(false);

			// open the experiment frame
			new ExperimentController3();

		}

		// if the last button is pressed
		else if (e.getSource() == edu3.lastButton) {

			// close the current frame
			edu3.dispose();
			setVisible(false);

			// open the last frame
			new EducationFrameController2();

		}

		// if the next button is pressed
		else if (e.getSource() == edu3.nextButton) {

			// close the current frame
			edu3.dispose();
			setVisible(false);

			// open the next frame
			new EducationFrameController4();

		}
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
