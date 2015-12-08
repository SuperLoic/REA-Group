package com.rea.mark.base;

/**
 * Define four facing direction for robot
 * 
 * @author Mark
 *
 */
public enum Direction {
	NORTH(Degree.NORTH, "NORTH"), SOUTH(Degree.SOUTH, "SOUTH"), EAST(Degree.EAST, "EAST"), WEST(Degree.WEST, "WEST");
	private Direction(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public static int getDegreeByName(String name) {
		Direction[] values = Direction.values();
		// set default direction to be NORTH
		Direction currentDirection = Direction.NORTH;
		for (Direction direction : values) {
			if (direction.getName().equalsIgnoreCase(name)) {
				currentDirection = direction;
				break;
			}
		}
		return currentDirection.getDegree();
	}

	public int getDegree() {
		return value;
	}

	public String getName() {
		return desc;
	}

	public static Direction getDirection(int value) {
		Direction[] values = Direction.values();
		// set default direction to be NORTH
		Direction currentDirection = Direction.NORTH;
		for (Direction direction : values) {
			if (direction.getDegree() == value) {
				currentDirection = direction;
				break;
			}
		}
		return currentDirection;
	}

	private int value;
	private String desc;

}
