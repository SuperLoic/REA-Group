package com.rea.mark.impl;

import com.rea.mark.base.Direction;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.IRobotActivity;

public class Robot implements IRobot {
	private int x;
	private int y;
	private Direction direction;
	private IRobotActivity robotActivity;

	public Robot(IRobotActivity robotActivity) {
		this.robotActivity = robotActivity;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public IRobotActivity getRobotActivity() {
		return robotActivity;
	}
}
