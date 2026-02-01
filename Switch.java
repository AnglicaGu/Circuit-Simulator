/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Switch
 * Description: Model class for switches
 */

package model;

import javax.swing.ImageIcon;

public class Switch extends Component {
	
	//extra field
    private boolean isOn;

    //constroctor
    public Switch(String id) {
        super(id, "switch", 10000.0, new ImageIcon("src/images/Switch.png")); // 默认断开
        this.isOn = false;
    }

    //getter
    public boolean getIsOn() {
        return isOn;
    }

    //utility method to toggle a switch
    public void toggle() {
    	
    	//reset isOn 
        isOn = !isOn;
        
        //set the rsistance
        //open: 10000
        //closed: 0
        resistance = isOn ? 0.0 : 10000.0;
        
        //set the icon
        setIcon(new ImageIcon(isOn ? "src/images/switch_on.png" : "src/images/Switch.png"));
    }
}
