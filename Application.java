/*
 * Name: Yu Gu
 * Date: Jun 13, 2025
 * Course Code: ICS4U1-01 Mrs. Biswas
 * Title: Yu's Circuit Simulator App
 * 
 * Description:
 * This project is a basic circuit simulator with two modules: experiment and 
 * material. In the experiment module, users can learn basic knowledge about different 
 * circuits and try to build one themselves. The program will tell if the circuit is 
 * valid or not, and it will show the correct circuit. In the materials module, 
 * users will see a bar chart showing the electrical conductivity of materials.
 * Then users can choose different materials of resistors to compare the brightness of bulbs.
 * 
 * Features:
 *  - Dragging and placing of components
 *  - Checking the validation of circuit (open, short,missing battery or good)
 *  - The switch is clickable and it can change the validation of circuit
 *  - Show the bulb light up when the line it's in can use
 *  - The buzzer can make sound when the line it's in can use
 *  - Bar chart of sorted electrical conductivity
 *  - Show different level of brightness of bulbs
 *  - Calculating the current based on material of resistor
 *  - Knowledge of circuits
 * 
 * Major Skills:
 *  - Object-Oriented Programming (OOP)
 *  - Dynamic UI updates based on user input
 *  - Inheritance and Polymorphism
 *  - GUI design with Swing components
 *  - Paint Panel
 *  - Data visualization using JFreeChart
 *  - File input
 *  - Data sorting
 *  - Event-driven programming with listeners and handlers
 * 
 * Added Features:
 *  1. Line graph comparison of air quality (PM2.5) with other province
 *  2. Bar and line charts of monthly/yearly provincial temperatures and precipitation
 *  3. Interactive map of Canada feature
 *  4. Additional climate education frames
 * 
 * Areas of Concern:
 *  - In experiment frames, user can click the warning button to go to the common mistake page,
 *  and click the ready button to go to the original education frame
 *  - User can change the component they put in by dragging another component into the grid
 *  - For the compare part, I just set three level of brigtness, it will be better if I can
 *  change the grightness by current more accurately.
 * 
 * Other documentation: (citations)
 *  - JFreeChart methods: https://www.jfree.org/jfreechart/api/javadoc/org/jfree/chart/JFreeChart.html
 *  - Dragging and placing methods:https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html
 *  
 */

package appication;

import controller.TitleFrameController;

public class Application {

	public static void main(String args[]) {
		new TitleFrameController();

	}

}
