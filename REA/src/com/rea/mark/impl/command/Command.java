package com.rea.mark.impl.command;

import com.rea.mark.impl.CommandResponse;
import com.rea.mark.inf.ICommand;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.IRobotActivity;
import com.rea.mark.inf.ITabletop;

public abstract class Command implements ICommand {
	protected IRobotActivity robotActivity;
	protected IRobot robot;
	protected ITabletop tabletop;

	public Command(IRobot robot, ITabletop tabletop) {
		this.robot = robot;
		this.tabletop = tabletop;
		robotActivity = robot.getRobotActivity();
	}

	protected IRobotActivity getRobotActivity() {
		return robotActivity;
	}

	protected IRobot getRobot() {
		return robot;
	}

	protected ITabletop getTabletop() {
		return tabletop;
	}

	/**
	 * Print out the log
	 * 
	 * @param msgs
	 */
	protected void log(String... msgs) {
		if (msgs.length == 1) {
			System.out.println(msgs[0]);
		} else {
			StringBuffer sb = new StringBuffer();
			for (String msg : msgs) {
				sb.append(msg);
			}
			System.out.println(sb.toString());
		}
	}

	@Override
	public CommandResponse execute() {
		// if robot is not on the tabletop, then ignore MOVE,LEFT,RIGHT and
		// REPORT command
		if (null == tabletop || null == robot) {
			log("A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands");
		}
		return executeCore();
	}

	/**
	 * Hook for overriden by MOVE,LEFT,RIGHT,REPORT
	 * 
	 * @param args
	 * @return
	 */
	protected CommandResponse executeCore() {
		return null;
	}

}
