/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Buzzer
 * Description: Model class for buzzers
 */

package model;

import javax.swing.ImageIcon;

public class Buzzer extends Component {

	//constructor
    public Buzzer(String id) {
        super(id, "buzzer", 16.0, new ImageIcon("src/images/buzzer.png")); // 假设蜂鸣器阻值为 5Ω
    }

    @Override
    public double getResistance() {
        return resistance;
    }
}
