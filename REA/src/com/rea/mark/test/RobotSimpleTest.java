package com.rea.mark.test;

import static com.rea.mark.base.Action.LEFT;
import static com.rea.mark.base.Action.MOVE;
import static com.rea.mark.base.Action.PLACE;
import static com.rea.mark.base.Action.REPORT;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rea.mark.base.Degree;
import com.rea.mark.impl.CommandResponse;
import com.rea.mark.impl.Robot;
import com.rea.mark.impl.RobotActivity;
import com.rea.mark.impl.RobotController;
import com.rea.mark.impl.Tabletop;
import com.rea.mark.impl.command.ReportCommand;

/**
 * Test Examples
 * 
 * @author Mark
 *
 */
public class RobotSimpleTest {
	int xUnits = 5;
	int yUnits = 5;
	RobotController robotController = null;
	CommandResponse response = null;

	@Before
	public void init() {
		robotController = new RobotController(new Robot(new RobotActivity()), new Tabletop(5, 5));
	}

	@Test
	public void exampleA() {
		// Given command

		Map<Class<?>, CommandResponse> map = robotController.command(PLACE, new int[] { 0, 0, Degree.NORTH })
				.command(MOVE).command(REPORT).execute();
		response = map.get(ReportCommand.class);
		Assert.assertEquals("0,1,NORTH", response.getMessage());
	}

	@Test
	public void exampleB() {
		Map<Class<?>, CommandResponse> map = robotController.command(PLACE, new int[] { 0, 0, Degree.NORTH })
				.command(LEFT).command(REPORT).execute();
		response = map.get(ReportCommand.class);
		Assert.assertEquals("0,0,WEST", response.getMessage());
	}

	@Test
	public void exampleC() {
		Map<Class<?>, CommandResponse> map = robotController.command(PLACE, new int[] { 1, 2, Degree.EAST })
				.command(MOVE).command(MOVE).command(LEFT).command(MOVE).command(REPORT).execute();
		response = map.get(ReportCommand.class);
		Assert.assertEquals("3,3,NORTH", response.getMessage());
	}

	@Test
	public void exampleD() {
		// Given command
		Map<Class<?>, CommandResponse> map = robotController.command("place 0,0,north").command("move")
				.command("report").execute();
		response = map.get(ReportCommand.class);
		Assert.assertEquals("0,1,NORTH", response.getMessage());
	}

	@Test
	public void exampleE() {
		Map<Class<?>, CommandResponse> map = robotController.command("place 0,0,north").command("left")
				.command("report").execute();
		response = map.get(ReportCommand.class);
		Assert.assertEquals("0,0,WEST", response.getMessage());
	}

	@Test
	public void exampleF() {
		Map<Class<?>, CommandResponse> map = robotController.command("place 1,2,east").command("move").command("move")
				.command("left").command("move").command("report").execute();
		response = map.get(ReportCommand.class);
		Assert.assertEquals("3,3,NORTH", response.getMessage());
	}

	@After
	public void destroy() {
		robotController = null;
		response = null;
	}

}
