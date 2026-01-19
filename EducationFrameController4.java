/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrameController4
 * Description: Controller for EducationFrame4. 
 * Handles buttons.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EducationFrame1;
import view.EducationFrame2;
import view.EducationFrame3;
import view.EducationFrame4;

public class EducationFrameController4 implements ActionListener {

	EducationFrame4 edu4 = new EducationFrame4();

	// constructor
	public EducationFrameController4() {

		// add action listeners to the buttons and combo boxes
		edu4.homeButton.addActionListener(this);
		edu4.materialButton.addActionListener(this);
		edu4.lastButton.addActionListener(this);
		edu4.nextButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the home button is pressed
		if (e.getSource() == edu4.homeButton) {

			// close the current frame
			edu4.dispose();
			setVisible(false);

			// open the title frame
			new TitleFrameController();

		}

		// if the material button is pressed
		else if (e.getSource() == edu4.materialButton) {

			// close the current frame
			edu4.dispose();
			setVisible(false);

			// open the material chart frame
			new MaterialChartController();

		}

		// if the last button is pressed
		else if (e.getSource() == edu4.lastButton) {

			// close the current frame
			edu4.dispose();
			setVisible(false);

			// open the last frame
			new EducationFrameController3();

		}

		// if the next button is pressed
		else if (e.getSource() == edu4.nextButton) {

			// close the current frame
			edu4.dispose();
			setVisible(false);

			// open the next frame
			new EducationFrameController5();

		}
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
