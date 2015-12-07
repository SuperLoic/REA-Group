package com.rea.mark.inf;

import com.rea.mark.base.Direction;
import com.rea.mark.base.Rotation;

/**
 * IRobotActivity interface defined robot's activities
 * 
 * @see IRobot
 * @see ITabletop
 * @see Rotation
 * @author Mark
 *
 */
public interface IRobotActivity {

	/**
	 * Robot be able to move forward on the tabletop
	 * 
	 * @param robot
	 *            robot which is on the tabletop
	 * @param tabletop
	 *            tabletop where there is a robot
	 */
	void move(IRobot robot, ITabletop tabletop);

	/**
	 * Robot be able to rotate left or right
	 * 
	 * @param robot
	 *            robot which is on the tabletop
	 * @param tabletop
	 *            tabletop where there is a robot
	 * @param rotation
	 *            rotaione
	 */
	void turn(IRobot robot, ITabletop tabletop, Rotation rotation);

	/**
	 * Robot be able to report current position and orientation
	 * 
	 * @param robot
	 *            robot which is on the tabletop
	 * @param tabletop
	 *            tabletop where there is a robot
	 */
	void report(IRobot robot, ITabletop tabletop);

	/**
	 * Enable to place robot on specific position and orientation
	 * 
	 * @param robot
	 *            robot which is on the tabletop
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 * @param direction
	 *            initial direction
	 */
	void place(IRobot robot, int x, int y, Direction direction);

	/**
	 * Enable to place robot on specific position and orientation
	 * 
	 * @param robot
	 *            robot which is on the tabletop
	 * @param x
	 *            position x
	 * @param y
	 *            position y
	 * @param direction
	 *            initial direction degree
	 */
	void place(IRobot robot, int x, int y, int degree);
}
