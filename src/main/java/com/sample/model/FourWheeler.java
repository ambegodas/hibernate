/**
 * @autor pathmasri
 * May 9, 2015 4:29:02 PM
 */
package com.sample.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class FourWheeler extends GenericVehicle {
	
	private String steeringWheeler;

	/**
	 * @return the steeringWheeler
	 */
	public String getSteeringWheeler() {
		return steeringWheeler;
	}

	/**
	 * @param steeringWheeler the steeringWheeler to set
	 */
	public void setSteeringWheeler(String steeringWheeler) {
		this.steeringWheeler = steeringWheeler;
	}
	
	

}
