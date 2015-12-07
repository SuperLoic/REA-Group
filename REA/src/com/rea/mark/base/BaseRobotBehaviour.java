package com.rea.mark.base;

import com.rea.mark.inf.IRobotBehaviour;

/**
 * Base behaviours for robot
 * 
 * @author Mark
 *
 */
public class BaseRobotBehaviour implements IRobotBehaviour {
	protected final int NORTH = 1;
	protected final int SOUTH = 1 << 1;
	protected final int EAST = 1 << 2;
	protected final int WEST = 1 << 3;

	@Override
	public void faceNorth() {
		faceOrientation(NORTH);
	}

	@Override
	public void faceSouth() {
		faceOrientation(SOUTH);
	}

	@Override
	public void faceEast() {
		faceOrientation(EAST);
	}

	@Override
	public void faceWest() {
		faceOrientation(WEST);

	}

	protected void faceOrientation(int orientation) {
	}

}
