/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Component
 * Description: Abstract model class that defines the basic fields and methods of all components
 */

package model;

import javax.swing.ImageIcon;

public abstract class Component {

	//fields
    protected String id;             // to tell same type of components
    protected String type;           
    protected double resistance;     
    protected ImageIcon icon;        

    //constructor
    public Component(String id, String type, double resistance, ImageIcon icon) {
        this.id = id;
        this.type = type;
        this.resistance = resistance;
        this.icon = icon;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

	public abstract double getResistance();

    public ImageIcon getIcon() {
        return icon;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    
    public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}
}
