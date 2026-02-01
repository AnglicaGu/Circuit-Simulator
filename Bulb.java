/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Bulb
 * Description: Model class for bulbs
 */

package model;

import javax.swing.ImageIcon;

public class Bulb extends Component {

	//extra field
    private int brightnessLevel; // e.g. 0 = off, 1 = dim, 2 = bright

    //constructor
    public Bulb(String id) {
        super(id, "bulb", 10.0, new ImageIcon("src/images/bulb.png")); // 默认阻值 5Ω
        this.brightnessLevel = 0;
    }

    //getters and setters
    @Override
    public double getResistance() {
        return resistance;
    }

    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    public void setBrightnessLevel(int level) {
        this.brightnessLevel = level;
    }
}
