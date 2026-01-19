/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: EducationFrameController5
 * Description: Controller for EducationFrame5. 
 * Handles buttons.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EducationFrame5;

public class EducationFrameController5 implements ActionListener {

	EducationFrame5 edu5 = new EducationFrame5();

	// constructor
	public EducationFrameController5() {

		// add action listeners to the buttons and combo boxes
		edu5.homeButton.addActionListener(this);
		edu5.materialButton.addActionListener(this);
		edu5.lastButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if the home button is pressed
		if (e.getSource() == edu5.homeButton) {

			// close the current frame
			edu5.dispose();
			setVisible(false);

			// open the title frame
			new TitleFrameController();

		}

		// if the material button is pressed
		else if (e.getSource() == edu5.materialButton) {

			// close the current frame
			edu5.dispose();
			setVisible(false);

			// open the maerial chart frame
			new MaterialChartController();

		}

		// if the last button is pressed
		else if (e.getSource() == edu5.lastButton) {

			// close the current frame
			edu5.dispose();
			setVisible(false);

			// open the last frame
			new EducationFrameController4();

		}

	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
