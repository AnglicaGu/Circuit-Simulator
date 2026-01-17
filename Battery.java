/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Battery
 * Description: Model class for battery
 */

package model;

import javax.swing.ImageIcon;

public class Battery extends Component {

	//extra field
    private double voltage;

    //constructor
    public Battery(String id,double voltage) {
        super(id, "battery", 0.0, new ImageIcon("src/images/battery.png"));
        this.voltage = voltage;
    }
    
    //default voltage 5.0V
    public Battery(String id) {
        this(id,5.0); //
    }

    public double getVoltage() {
        return voltage;
    }

    //rewrite the get resistance method
    @Override
    public double getResistance() {
        return 0.0;
    }
}
