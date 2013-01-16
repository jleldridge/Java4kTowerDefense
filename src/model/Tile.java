package model;

import model.Effect.Effect;
import model.Entity.Entity;
import model.Terrain.Terrain;

/**
 * generic Tile object consisting of a terrain, entity, and effect.
 */
public class Tile {
	// fields
	Terrain terr;
	Effect eff;
	
	// constructor
	public Tile() {
		this.terr = null;
		this.eff = null;
	}
	
	public Tile(Terrain terr, Effect eff) {
		this.terr = terr;
		this.eff = eff;
	}
	
	// setter/getters
	public void setTerrain(Terrain terr) { this.terr = terr; }
	public Terrain getTerrain() { return this.terr; }
	public void setEffect(Effect eff) { this.eff = eff; }
	public Effect getEffect() { return this.eff; }
	public Tile getTile() { return this; }
}
