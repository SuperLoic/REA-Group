package com.rea.mark.impl.command;

import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class PlaceCommand extends Command {

	public PlaceCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected boolean executeCore(int... args) {
		// place command only have 3 arguments, x, y and degree
		if (args.length != 3) {
			return false;
		}

		int x = args[0];
		int y = args[1];
		int xUnits = tabletop.getXUnits();
		int yUnits = tabletop.getYUnits();

		if (0 > x || x > (xUnits - 1) || 0 > y || y > (yUnits - 1)) {
			return false;
		}

		int degree = args[2];
		robotActivity.place(robot, xUnits, yUnits, degree);
		return true;
	}

}
