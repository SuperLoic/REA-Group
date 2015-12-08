package com.rea.mark.impl.command;

import com.rea.mark.impl.CommandResponse;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class ReportCommand extends Command {

	public ReportCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected CommandResponse executeCore() {
		log("REPORT");
		String report = robotActivity.report(robot, tabletop);
		log(System.lineSeparator(), System.lineSeparator(), "=======================", System.lineSeparator());
		return new CommandResponse(true, this.getClass(), report, hashCode());
	}

}
