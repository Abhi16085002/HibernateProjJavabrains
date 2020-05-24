package org.javabrains.koushik.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String userName;
	@ElementCollection
	private Set<Address> listOfAddress = new HashSet<Address>();
	
	
	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName + " from getter" ;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}