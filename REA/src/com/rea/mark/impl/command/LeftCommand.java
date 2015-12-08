package com.rea.mark.impl.command;

import com.rea.mark.base.Rotation;
import com.rea.mark.impl.CommandResponse;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class LeftCommand extends Command {

	public LeftCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected CommandResponse executeCore() {
		log("LEFT");
		robotActivity.turn(robot, tabletop, Rotation.LEFT);
		return new CommandResponse(true, this.getClass(), "SUCCESSFULLY ROTATE LEFT", hashCode());
	}

}
