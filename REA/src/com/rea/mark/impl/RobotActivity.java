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
	public boolean move(IRobot robot, ITabletop tabletop) {
		Direction direction = robot.getDirection();
		boolean moveStatus = true;
		switch (direction) {
		case NORTH:
			moveStatus = move(robot, tabletop, 0, 1);
			break;
		case SOUTH:
			moveStatus = move(robot, tabletop, 0, -1);
			break;
		case EAST:
			moveStatus = move(robot, tabletop, 1, 0);
			break;
		case WEST:
			moveStatus = move(robot, tabletop, -1, 0);
		default:
			break;
		}
		return moveStatus;
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
	public boolean move(IRobot robot, ITabletop tabletop, int offsetX, int offestY) {
		int maxYUnits = tabletop.getYUnits();
		int maxXUnits = tabletop.getXUnits();
		int currentX = robot.getX();
		int currentY = robot.getY();
		// prevent robot from falling to destruction
		int newX = currentX + offsetX;
		int newY = currentY + offestY;

		// restrict current position
		if (newX > (maxXUnits - 1) || newX < 0 || newY > (maxYUnits - 1) || newY < 0) {
			return false;
		}

		// update current position
		robot.setX(newX);
		robot.setY(newY);
		return true;
	}

	@Override
	public void turn(IRobot robot, ITabletop tabletop, Rotation rotation) {
		int currentDegree = robot.getDirection().getDegree();
		int offsetDegree = rotation.getDegree();
		int newDegree = currentDegree + offsetDegree;
		newDegree = newDegree < 0 ? (360 + newDegree) : newDegree;
		// 360 degree and 0 degree both are at the same orientation
		currentDegree = newDegree == 360 ? 0 : newDegree;
		// update the direction of robot
		robot.setDirection(Direction.getDirection(currentDegree));
	}

	@Override
	public String report(IRobot robot, ITabletop tabletop) {
		System.out.println();
		System.out.println("Expected output:");
		System.out.println();
		String reportResult = String.format("%d,%d,%s", robot.getX(), robot.getY(), robot.getDirection().getName());
		System.out.printf(reportResult);
		return reportResult;
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
