package com.rea.mark.inf;

/**
 * Robot commands
 * 
 * @author Mark
 *
 */
public interface IRobotCommand {
	/**
	 * Move forward command
	 */
	void move();

	/**
	 * Rotate -90 degrees command
	 */
	void left();

	/**
	 * Rotate 90 degrees command
	 */
	void right();

	/**
	 * Report current situation command
	 */
	void report();
}
