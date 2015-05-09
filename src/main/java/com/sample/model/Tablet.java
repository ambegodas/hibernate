/**
 * @autor pathmasri
 * May 9, 2015 5:16:41 PM
 */
package com.sample.model;

import javax.persistence.Entity;

@Entity
public class Tablet extends Computer {
	
	private String touchScreenType;

	/**
	 * @return the touchScreenType
	 */
	public String getTouchScreenType() {
		return touchScreenType;
	}

	/**
	 * @param touchScreenType the touchScreenType to set
	 */
	public void setTouchScreenType(String touchScreenType) {
		this.touchScreenType = touchScreenType;
	}
	
	

}
