/**
 * @autor pathmasri
 * May 9, 2015 5:16:14 PM
 */
package com.sample.model;

import javax.persistence.Entity;

@Entity
public class Desktop extends Computer {
	
	private String monitorType;

	/**
	 * @return the monitorType
	 */
	public String getMonitorType() {
		return monitorType;
	}

	/**
	 * @param monitorType the monitorType to set
	 */
	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}
	
	
}
