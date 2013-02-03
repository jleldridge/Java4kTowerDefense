package model;

import model.Effect.Effect;
import model.Entity.Entity;
import model.Terrain.Terrain;

/**
 * generic Tile object consisting of a terrain, entity, and effect.
 */
public class Tile {
	// fields
	public Terrain terrain;
	public Effect effect;
	
	// constructor
	public Tile() {
		this.terrain = null;
		this.effect = null;
	}
	
	public Tile(Terrain terr, Effect eff) {
		this.terrain = terr;
		this.effect = eff;
	}
}
