package com.rea.mark.impl.command;

import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class ReportCommand extends Command {

	public ReportCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected boolean executeCore(int... args) {
		robotActivity.report(robot, tabletop);
		return true;
	}

}
