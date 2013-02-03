package model;

import model.Effect.Effect;
import model.Entity.Entity;

/**
 * generic Tile object consisting of a terrain, entity, and effect.
 */
public class Tile {
	// fields
	public Effect effect;
	
	// constructor
	public Tile() {
		this.effect = null;
	}
	
	public Tile(Effect eff) {
		this.effect = eff;
	}
}
