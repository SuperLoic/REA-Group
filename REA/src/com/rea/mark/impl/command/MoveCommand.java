package com.rea.mark.impl.command;

import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class MoveCommand extends Command {

	public MoveCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected boolean executeCore(int... args) {
		robotActivity.move(robot, tabletop);
		return true;
	}

}
