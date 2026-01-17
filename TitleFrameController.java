/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: TitleFrameController
 * Description: Controller for title frame.
 */

package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.TitleFrame;


public class TitleFrameController implements ActionListener {

	//the view
	TitleFrame title = new TitleFrame();

	// constructor
	public TitleFrameController() {

		// add action listeners to the buttons and combo boxes
		title.experiButton.addActionListener(this);
		title.materialButton.addActionListener(this);

	}

	//enable all the buttons
	@Override
	public void actionPerformed(ActionEvent e) {

		// if the experiment button is pressed
		if (e.getSource() == title.experiButton) {

			// close the current frame
			title.dispose();
			setVisible(false);

			// open the education frame 1
			new EducationFrameController1();

		}

		// if the material button is pressed
		else if (e.getSource() == title.materialButton) {

			// close the current frame
			title.dispose();
			setVisible(false);

			// open the material chart frame
			new MaterialChartController();

		}
	}

	//method to set visibility
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
