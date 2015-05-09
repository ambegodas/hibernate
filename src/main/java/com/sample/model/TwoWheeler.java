/**
 * @autor pathmasri
 * May 9, 2015 4:27:38 PM
 */
package com.sample.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class TwoWheeler extends GenericVehicle {
	
	private String steerHandle;

	/**
	 * @return the steerHandle
	 */
	public String getSteerHandle() {
		return steerHandle;
	}

	/**
	 * @param steerHandle the steerHandle to set
	 */
	public void setSteerHandle(String steerHandle) {
		this.steerHandle = steerHandle;
	}

	
}
