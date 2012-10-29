package model;

/**
 * generic Tile object consisting of a terrain, entity, and effect.
 */
public class Tile {
	// fields
	Terrain terr;
	
	
	// constructor
	Tile(Terrain terr) {
		this.terr = terr;
	}
	
	// setter/getters
	public void setTerrain(Terrain terr) { this.terr = terr; }
	public Terrain getTerrain() { return this.terr; }
	
}
