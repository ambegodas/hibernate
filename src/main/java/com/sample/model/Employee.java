/**
 * @autor pathmasri
 * May 9, 2015 10:25:46 AM
 */
package com.sample.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id @GeneratedValue
	private int employeeId;
	private String employeeName;
	
/*	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;*/
    
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="USER_VEHICLE",joinColumns =@JoinColumn(name="EMP_ID"),
	inverseJoinColumns = @JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@ManyToMany
	private Collection<LapTop> laptops = new ArrayList<LapTop>();
	
	
	
	/**
	 * @return the laptops
	 */
	public Collection<LapTop> getLaptops() {
		return laptops;
	}
	/**
	 * @param laptops the laptops to set
	 */
	public void setLaptops(Collection<LapTop> laptops) {
		this.laptops = laptops;
	}
	/**
	 * @return the vehicles
	 */
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	

}
