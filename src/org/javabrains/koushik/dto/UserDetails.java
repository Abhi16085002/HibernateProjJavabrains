package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String userName;
	@ElementCollection
	@JoinTable(name="USER_ADDRESS", 
				joinColumns = @JoinColumn(name="USER_ID")
			)
	@GenericGenerator(name = "hilo-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type (type="long") )
    //private Set<Address> listOfAddress = new HashSet<Address>();
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
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