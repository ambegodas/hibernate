/**
 * @autor pathmasri
 * May 9, 2015 9:56:59 AM
 */
package com.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue
	private int vehichleId;
	private String vehicleName;
	
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private Employee user;
	
	
	
	/**
	 * @return the user
	 */
	public Employee getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Employee user) {
		this.user = user;
	}
	/**
	 * @return the vehichleId
	 */
	public int getVehichleId() {
		return vehichleId;
	}
	/**
	 * @param vehichleId the vehichleId to set
	 */
	public void setVehichleId(int vehichleId) {
		this.vehichleId = vehichleId;
	}
	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}
	/**
	 * @param vehicleName the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	

}
