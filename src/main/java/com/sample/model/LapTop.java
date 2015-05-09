/**
 * @autor pathmasri
 * May 9, 2015 11:41:21 AM
 */
package com.sample.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class LapTop {
	
	@Id @GeneratedValue
	private int laptopId;
	private String laptopName;
	
	@ManyToMany(mappedBy = "laptops")
	private Collection<Employee> employees = new ArrayList<Employee>();
	/**
	 * @return the laptopId
	 */
	public int getLaptopId() {
		return laptopId;
	}
	/**
	 * @param laptopId the laptopId to set
	 */
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	/**
	 * @return the laptopName
	 */
	public String getLaptopName() {
		return laptopName;
	}
	/**
	 * @param laptopName the laptopName to set
	 */
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	/**
	 * @return the employees
	 */
	public Collection<Employee> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	
	
	

}
