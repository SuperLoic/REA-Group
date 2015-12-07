package com.rea.mark.impl;

import com.rea.mark.base.Direction;
import com.rea.mark.base.Rotation;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.IRobotActivity;
import com.rea.mark.inf.ITabletop;

/**
 * Base behaviours for robot
 * 
 * @author Mark
 *
 */
public class RobotActivity implements IRobotActivity {

	@Override
	public void move(IRobot robot, ITabletop tabletop) {
		Direction direction = robot.getDirection();
		switch (direction) {
		case NORTH:
			move(robot, tabletop, 0, 1);
			break;
		case SOUTH:
			move(robot, tabletop, 0, -1);
			break;
		case EAST:
			move(robot, tabletop, 1, 0);
			break;
		case WEST:
			move(robot, tabletop, -1, 0);
		default:
			break;
		}
	}

	/**
	 * Robot move on the tabletop
	 * 
	 * @param robot
	 *            robot which is on the tabletop
	 * @param tabletop
	 *            tabletop where there is a robot
	 * @param offsetX
	 *            instruction of x direction move steps
	 * @param offestY
	 *            instruction of y direction move steps
	 */
	public void move(IRobot robot, ITabletop tabletop, int offsetX, int offestY) {
		int maxYUnits = tabletop.getYUnits();
		int maxXUnits = tabletop.getXUnits();
		int currentX = robot.getX();
		int currentY = robot.getY();
		// prevent robot from falling to destruction
		currentX = (currentX + offsetX) <= maxXUnits ? (currentX + offsetX) : maxXUnits;
		currentY = (currentY + offestY) <= maxYUnits ? (currentY + offestY) : maxYUnits;
		robot.setX(currentX);
		robot.setY(currentY);
	}

	@Override
	public void turn(IRobot robot, ITabletop tabletop, Rotation rotation) {
		int currentDegree = robot.getDirection().getDegree();
		int offsetDegree = rotation.getDegree();
		// 360 degree and 0 degree both are at the same orientation
		currentDegree = ((currentDegree + offsetDegree) == 360) ? 0 : (currentDegree + offsetDegree);
		// update the direction of robot
		robot.setDirection(Direction.getDirection(currentDegree));
	}

	@Override
	public void report(IRobot robot, ITabletop tabletop) {
		System.out.printf("%d,%d,%s", robot.getX(), robot.getY(), robot.getDirection().getDescription());
	}

	@Override
	public void place(IRobot robot, int x, int y, Direction direction) {
		robot.setX(x);
		robot.setY(y);
		robot.setDirection(direction);
	}

	@Override
	public void place(IRobot robot, int x, int y, int degree) {
		place(robot, x, y, Direction.getDirection(degree));
	}

}
