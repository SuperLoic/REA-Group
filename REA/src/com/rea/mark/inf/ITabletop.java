package com.rea.mark.inf;

/**
 * Tabletop properties accessor
 * 
 * @author Mark
 *
 */
public interface ITabletop {
	/**
	 * Set height of the tabletop
	 * 
	 * @param height
	 *            table height
	 */
	void setYUnits(int height);

	/**
	 * Get height of the tabletop
	 * 
	 * @return tabletop height
	 */
	int getYUnits();

	/**
	 * Set width of the tabletop
	 * 
	 * @param width
	 *            tabletop width
	 */
	void setXUnits(int width);

	/**
	 * Get width of the tabletop
	 * 
	 * @return tabletop width
	 */
	int getXUnits();

	/**
	 * Set the dimension of tabletop
	 * 
	 * @param height
	 * @param width
	 */
	void setDimension(int height, int width);
}
