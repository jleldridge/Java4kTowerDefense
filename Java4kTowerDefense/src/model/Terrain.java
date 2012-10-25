package model;

abstract class Terrain implements Viewable {
	// fields
	// are entities able to cross a given terrain type?
	public boolean traversable;
	// are spells able to destroy a given terrain type?
	public boolean destructable;
	// grid coordinates for a given terrain type
	private int x, y;
	
	// setters/getters
	public int getX() { return this.x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return this.y; }
	public void setY(int y) { this.y = y; }	
	public boolean getTraversable() { return this.traversable; }
	public boolean getDestructable() { return this.destructable; }
}


