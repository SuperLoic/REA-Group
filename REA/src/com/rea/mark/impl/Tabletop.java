package com.rea.mark.impl;

import com.rea.mark.inf.ITabletop;

public class Tabletop implements ITabletop {
	private int height;
	private int width;

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
