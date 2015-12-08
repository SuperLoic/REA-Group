package com.rea.mark.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.rea.mark.base.Action;
import com.rea.mark.impl.command.LeftCommand;
import com.rea.mark.impl.command.MoveCommand;
import com.rea.mark.impl.command.PlaceCommand;
import com.rea.mark.impl.command.ReportCommand;
import com.rea.mark.impl.command.RightCommand;
import com.rea.mark.inf.ICommand;
import com.rea.mark.inf.IRobot;
import com.rea.mark.inf.IRobotCommand;
import com.rea.mark.inf.ITabletop;

/**
 * RobotController provide variety of way to give instructions to robot. The
 * instructions include
 * <ul>
 * <li>Place robot on the tabletop</li>
 * <li>Robot is able to turn left</li>
 * <li>Robot be able to turn right</li>
 * <li>Robot be able to move forward</li>
 * <li>Robot be able to report current situation</li>
 * </ul>
 * 
 * 
 * @author Mark
 *
 */
public class RobotController implements IRobotCommand {
	private List<ICommand> commands = new LinkedList<ICommand>();
	private IRobot robot;
	private ITabletop tabletop;

	public RobotController() {
		this(new Robot(new RobotActivity()), new Tabletop(5, 5));
	}

	public RobotController(IRobot robot, ITabletop tabletop) {
		this.robot = robot;
		this.tabletop = tabletop;
	}

	/**
	 * Execute command queue
	 * 
	 * @return executed command result
	 */
	public Map<Class<?>, CommandResponse> execute() {
		boolean isExecutedSuccessfully = true;
		Map<Class<?>, CommandResponse> map = new HashMap<>();
		for (ICommand command : commands) {
			CommandResponse response = command.execute();
			map.put(response.getClazz(), response);
			isExecutedSuccessfully = response.isSuccessfullyExecuted();
			if (!isExecutedSuccessfully) {
				break;
			}
		}
		return map;
	}

	/**
	 * Append an action instruction by command line
	 * 
	 * @param specificAction
	 *            command line
	 * @return RobotController
	 */
	public RobotController command(String specificAction) {
		for (Action action : Action.values()) {
			boolean matches = Pattern.matches(action.getRegex(), specificAction.toUpperCase());
			if (matches) {
				command(action, action.getArgs(specificAction));
				break;
			}
		}
		return this;
	}

	/**
	 * Append an action instruction without args
	 * 
	 * @param action
	 *            command action
	 * @return RobotController
	 */
	public RobotController command(Action action) {
		return command(action, null);
	}

	/**
	 * Append an action instruction with args to robot instruction queue
	 * 
	 * @param action
	 *            command action
	 * @param args
	 *            command args
	 * @return RobotController
	 */
	public RobotController command(Action action, int... args) {
		switch (action) {
		case PLACE:
			append(new PlaceCommand(robot, tabletop, args));
			break;
		case MOVE:
			append(new MoveCommand(robot, tabletop));
			break;
		case LEFT:
			append(new LeftCommand(robot, tabletop));
			break;
		case RIGHT:
			append(new RightCommand(robot, tabletop));
			break;
		case REPORT:
		default:
			append(new ReportCommand(robot, tabletop));
			break;
		}
		return this;
	}

	private void append(ICommand command) {
		commands.add(command);
	}

	@Override
	public CommandResponse move() {
		return new MoveCommand(robot, tabletop).execute();
	}

	@Override
	public CommandResponse left() {
		return new LeftCommand(robot, tabletop).execute();
	}

	@Override
	public CommandResponse right() {
		return new RightCommand(robot, tabletop).execute();
	}

	@Override
	public CommandResponse report() {
		return new ReportCommand(robot, tabletop).execute();
	}

	@Override
	public CommandResponse place(int... args) {
		return new PlaceCommand(robot, tabletop, args).execute();
	}

	public List<ICommand> getCommands() {
		return commands;
	}

	public void setCommands(List<ICommand> commands) {
		this.commands = commands;
	}

	public IRobot getRobot() {
		return robot;
	}

	public ITabletop getTabletop() {
		return tabletop;
	}

}
