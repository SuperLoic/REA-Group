package com.rea.mark.impl;

import com.rea.mark.inf.ITabletop;

/**
 * Tabletop is a place for robot playing on
 * 
 * @author Mark
 *
 */
public class Tabletop implements ITabletop {
	private int height;
	private int width;

	public Tabletop(int height, int width) {
		this.height = height;
		this.width = width;
	}

	@Override
	public void setYUnits(int height) {
		this.height = height;
	}

	@Override
	public int getYUnits() {
		return height;
	}

	@Override
	public void setXUnits(int width) {
		this.width = width;
	}

	@Override
	public int getXUnits() {
		return width;
	}

	@Override
	public void setDimension(int height, int width) {
		this.width = width;
		this.height = height;
	}
}
