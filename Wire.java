/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Wire
 * Description: Model class for wires
 */

package model;

import javax.swing.ImageIcon;

public class Wire extends Component {

	//constructor
    public Wire(String id) {
        super(id, "wire", 0.0, new ImageIcon("src/images/wire.png")); // 理想导线
    }

    //override the getresistance method and set resistance 0
    @Override
    public double getResistance() {
        return 0.0;
    }
}
