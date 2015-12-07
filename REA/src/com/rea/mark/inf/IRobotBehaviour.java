package com.rea.mark.inf;

/**
 * RobotBehaviour interface defined robot's behaviours
 * 
 * @author Mark
 *
 */
public interface IRobotBehaviour {
	/**
	 * Robot be able to face north
	 */
	void faceNorth();

	/**
	 * Robot be able to face south
	 */
	void faceSouth();

	/**
	 * Robot be able to face east
	 */
	void faceEast();

	/**
	 * Robot be able to face west
	 */
	void faceWest();
}
