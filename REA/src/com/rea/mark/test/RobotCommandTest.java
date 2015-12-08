package com.rea.mark.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

import com.rea.mark.base.Direction;
import com.rea.mark.impl.CommandResponse;
import com.rea.mark.impl.Robot;
import com.rea.mark.impl.RobotActivity;
import com.rea.mark.impl.RobotController;
import com.rea.mark.impl.Tabletop;
import com.rea.mark.inf.IRobot;

/**
 * RobotCommand Test
 * 
 * @author Mark
 *
 */
public class RobotCommandTest {
	int xUnits = 5;
	int yUnits = 5;
	RobotController robotController = null;
	CommandResponse response = null;
	IRobot robot = null;

	@Before
	public void init() {
		robotController = new RobotController(new Robot(new RobotActivity()), new Tabletop(5, 5));
		robot = robotController.getRobot();
	}

	/**
	 * Feature - As a player,I want to place the robot at the correct position
	 * of tabletop so that it won't be falling to destruction
	 */
	@Test
	public void place() {
		// Given
		int direction = Direction.NORTH.getDegree();
		int x = 0;
		int y = 0;
		int[] args = { x, y, direction };

		// When
		robotController.place(args);

		// Then
		Assert.assertEquals("0,0,NORTH", robot.toString());
	}

	/**
	 * Feature - As a player, I wish robot is able to move forward and alarm
	 * when next movement would result in the robot falling from the table so
	 * that robot could be prevented from falling to destruction
	 */
	@Test
	public void move() {
		// Given
		int direction = Direction.NORTH.getDegree();
		int x = 0;
		int y = 0;
		int[] args = { x, y, direction };

		// When
		robotController.place(args);
		robotController.move();
		robotController.report();

		// Then
		Assert.assertEquals("0,1,NORTH", robot.toString());
	}

	/**
	 * Feature - As a player, I wish robot is able to turn left so that robot
	 * can move around the table
	 */
	@Test
	public void left() {
		// Given
		int direction = Direction.NORTH.getDegree();
		int x = 0;
		int y = 0;
		int[] args = { x, y, direction };

		// When
		robotController.place(args);
		robotController.left();
		robotController.report();

		// Then
		Assert.assertEquals("0,0,WEST", robot.toString());
	}

	/**
	 * Feature - As a player, I wish robot is able to turn right so that robot
	 * can move around the table
	 */
	@Test
	public void right() {
		// Given
		int direction = Direction.NORTH.getDegree();
		int x = 0;
		int y = 0;
		int[] args = { x, y, direction };

		// When
		robotController.place(args);
		robotController.right();
		robotController.report();

		// Then
		Assert.assertEquals("0,0,EAST", robot.toString());
	}

	/**
	 * Feature - As a player, I wish robot is able to report current position
	 * and orientation so that player can make further actions
	 */
	@Test
	public void report() {
		// Given
		int direction = Direction.NORTH.getDegree();
		int x = 0;
		int y = 0;
		int[] args = { x, y, direction };

		// When
		robotController.place(args);
		CommandResponse report = robotController.report();

		// Then
		Assert.assertEquals("0,0,NORTH", report.getMessage());
	}

	@After
	public void destory() {
		robotController = null;
		response = null;
		robot = null;
	}
}
