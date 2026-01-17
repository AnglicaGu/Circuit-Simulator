/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Resistor
 * Description: Model class for resistors
 */

package model;

import javax.swing.ImageIcon;

public class Resistor extends Component {

	//extra field
    private Material material;

    //set the length and area of the resistor
    private static final double LENGTH = 1.0;
    private static final double AREA = 1.0;

    //constructor
    public Resistor(String id, Material material) {
        super(id, "resistor", 0.0, new ImageIcon("src/images/resistor.png"));
        this.material = material;
        this.resistance = getResistance(); // 初始化电阻值
    }

    //override the getresistance to calculate it from resistivity
    @Override
    public double getResistance() {
        return material.getResistivity() * (LENGTH / AREA);
    }

    //getters and setters
    public String getMaterialName() {
        return material.getName();
    }

    public Material getMaterial() {
        return material;
    }
}
