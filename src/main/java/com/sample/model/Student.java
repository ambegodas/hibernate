/**
 * @autor pathmasri
 * May 9, 2015 6:13:32 PM
 */
package com.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="student.byId",query="from Student where studentId = ?")
@NamedNativeQuery(name="Student.byName",query="select * from Student where studentName = ?",resultClass = Student.class)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class Student {
	
	@Id @GeneratedValue
	private int studentId;
	private String studentName;
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	

}
