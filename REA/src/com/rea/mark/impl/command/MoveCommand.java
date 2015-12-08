package com.rea.mark.impl.command;

import com.rea.mark.impl.CommandResponse;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.ITabletop;

public class MoveCommand extends Command {

	public MoveCommand(IRobot robot, ITabletop tabletop) {
		super(robot, tabletop);
	}

	@Override
	protected CommandResponse executeCore() {
		log("MOVE");
		boolean isMoved = robotActivity.move(robot, tabletop);
		if (!isMoved) {
			log("MOVE FORWARD FAILED");
			return new CommandResponse(false, this.getClass(), "MOVE FORWARD FAILED", hashCode());
		}
		return new CommandResponse(true, this.getClass(), "SUCCESSFULLY MOVE FORWARD", hashCode());
	}

}
