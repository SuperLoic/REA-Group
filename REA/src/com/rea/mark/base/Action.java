package com.rea.mark.base;

/**
 * Define actions for robot
 * 
 * @author Mark
 *
 */
public enum Action {
	PLACE("PLACE", "PLACE\\s\\d{1},\\d{1},(NORTH|SOUTH|WEST|EAST)") {
		@Override
		public int[] getArgs(String command) {
			String[] split = command.split("\\s|,");
			return new int[] { Integer.valueOf(split[1]), Integer.valueOf(split[2]),
					Integer.valueOf(Direction.getDegreeByName(split[3])) };
		}
	},
	MOVE("MOVE", "MOVE") {
		@Override
		public int[] getArgs(String command) {
			return null;
		}
	},
	LEFT("LEFT", "LEFT") {
		@Override
		public int[] getArgs(String command) {
			return null;
		}
	},
	RIGHT("RIGHT", "RIGHT") {
		@Override
		public int[] getArgs(String command) {
			return null;
		}
	},
	REPORT("REPORT", "REPORT") {
		@Override
		public int[] getArgs(String command) {
			return null;
		}
	};
	private Action(String name, String regex) {
		this.name = name;
		this.regex = regex;
	}

	public String getName() {
		return name;
	}

	public String getRegex() {
		return regex;
	}

	// parse the args according to the regex
	public abstract int[] getArgs(String command);

	// command regex
	private String regex;
	// command name
	private String name;
}
