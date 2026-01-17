/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: Material
 * Description: Model for a material type
 */

package model;

public class Material {

	//fields
    private String name;
    private double conductivity;

    //constructor
    public Material(String name, double conductivity) {
        this.name = name;
        this.conductivity = conductivity;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public double getConductivity() {
        return conductivity;
    }

    public double getResistivity() {
        return 1.0 / conductivity;
    }

}
