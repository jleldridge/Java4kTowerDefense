package model;

/**
 * generic Tile object consisting of a terrain, entity, and effect.
 */
public class Tile {
	// fields
	Terrain terr;
	Entity ent;
	Effect eff;
	
	// constructor
	Tile(Terrain terr, Entity ent, Effect eff) {
		this.terr = terr;
		this.ent = ent;
		this.eff = eff;
	}
	
	// setter/getters
	public void setTerrain(Terrain terr) { this.terr = terr; }
	public Terrain getTerrain() { return this.terr; }
	public void setEntity(Entity ent) { this.ent = ent; }
	public Entity getEntity() { return this.ent; }
	public void setEffect(Effect eff) { this.eff = eff; }
	public Effect getEffect() { return this.eff; }
}
