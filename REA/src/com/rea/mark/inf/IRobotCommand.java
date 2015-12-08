package com.rea.mark.inf;

import com.rea.mark.impl.CommandResponse;

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
	CommandResponse move();

	/**
	 * Rotate -90 degrees command
	 */
	CommandResponse left();

	/**
	 * Rotate 90 degrees command
	 */
	CommandResponse right();

	/**
	 * Report current situation command
	 */
	CommandResponse report();
	
	/**
	 * Place robot on the tabletop
	 * @param args place position and orientation degree
	 */
	CommandResponse place(int...args);
}
