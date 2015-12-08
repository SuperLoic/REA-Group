package com.rea.mark.impl.command;

import com.rea.mark.base.Rotation;
import com.rea.mark.impl.CommandResponse;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class RightCommand extends Command {

	public RightCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected CommandResponse executeCore() {
		log("RIGHT");
		robotActivity.turn(robot, tabletop, Rotation.RIGHT);
		return new CommandResponse(true, this.getClass(), "SUCCESSFULLY ROTATE RIGHT", hashCode());
	}
}
