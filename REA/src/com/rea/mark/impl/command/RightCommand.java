package com.rea.mark.impl.command;

import com.rea.mark.base.Rotation;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class RightCommand extends Command {

	public RightCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected boolean executeCore(int... args) {
		robotActivity.turn(robot, tabletop, Rotation.RIGHT);
		return true;
	}
}
