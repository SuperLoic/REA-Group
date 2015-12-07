package com.rea.mark.inf;

import com.rea.mark.base.Direction;

/**
 * Robot
 * 
 * @author Mark
 *
 */
public interface IRobot {
	/**
	 * Set position x
	 * 
	 * @param x
	 *            position x
	 */
	void setX(int x);

	/**
	 * Get position x
	 * 
	 * @return position x
	 */
	int getX();

	/**
	 * Set position y
	 * 
	 * @param y
	 *            position y
	 */
	void setY(int y);

	/**
	 * Get position y
	 * 
	 * @return position y
	 */
	int getY();

	/**
	 * Set direction
	 * 
	 * @param direction
	 *            robot direction
	 * @see Direction
	 */
	void setDirection(Direction direction);

	/**
	 * Get direction
	 * 
	 * @return robot direction
	 * @see Direction
	 */
	Direction getDirection();
	
	/**
	 * Get RobotActivity
	 * @return
	 */
	IRobotActivity getRobotActivity();
}
