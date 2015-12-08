package com.rea.mark.impl.command;

import com.rea.mark.base.Direction;
import com.rea.mark.impl.CommandResponse;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class PlaceCommand extends Command {
	private int[] args;

	public PlaceCommand(IRobot robot, ITabletop tabletop) {
		this(robot, tabletop, null);
	}

	public PlaceCommand(IRobot robot, ITabletop tabletop, int... args) {
		super(robot, tabletop);
		this.args = args;
	}

	public void setArgs(int x, int y, Direction direction) {
		this.args = new int[] { x, y, direction.getDegree() };
	}

	@Override
	protected CommandResponse executeCore() {
		// place command only have 3 arguments, x, y and degree
		if (null == args || args.length != 3) {
			return new CommandResponse(false, this.getClass(), "POSITION X,Y AND DIRECTION ARE REQUIRED", hashCode());
		}

		int x = args[0];
		int y = args[1];
		int xUnits = tabletop.getXUnits();
		int yUnits = tabletop.getYUnits();

		if (0 > x || x > (xUnits - 1) || 0 > y || y > (yUnits - 1)) {
			System.out.printf("index %d,%d is outside of %d,%d", x, y, xUnits - 1, yUnits - 1);
			return new CommandResponse(false, this.getClass(), "PLACE A WRONG POSITION", hashCode());
		}

		int degree = args[2];
		Direction direction = Direction.getDirection(degree);
		robotActivity.place(robot, x, y, direction);
		// print log
		String report = String.format("PLACE %d,%d,%s", x, y, direction.getName());
		System.out.printf(report);
		System.out.println();

		return new CommandResponse(true, this.getClass(), report, hashCode());
	}

}
