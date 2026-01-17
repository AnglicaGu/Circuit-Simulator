/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: GridCell
 * Description: Model for a grid cell that can contain a component
 */

package model;

public class GridCell {

	//fields
    private int row;
    private int col;
    private Component component;

    //constructor
    public GridCell(int row, int col) {
        this.row = row;
        this.col = col;
        this.component = null; // 默认为空
    }
    
    //getters and setters
    public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	//utility method to check if the grid is empty
	public boolean isEmpty() {
        return component == null;
    }

}
