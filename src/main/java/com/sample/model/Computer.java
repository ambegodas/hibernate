/**
 * @autor pathmasri
 * May 9, 2015 5:15:56 PM
 */
package com.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)
public class Computer {
	
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int computerId;
	private String computerName;
	/**
	 * @return the computerId
	 */
	public int getComputerId() {
		return computerId;
	}
	/**
	 * @param computerId the computerId to set
	 */
	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}
	/**
	 * @return the computerName
	 */
	public String getComputerName() {
		return computerName;
	}
	/**
	 * @param computerName the computerName to set
	 */
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	
	

}
