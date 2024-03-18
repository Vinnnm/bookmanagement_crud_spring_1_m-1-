package bookmanagement.models;

import java.io.Serializable;

public class AuthorDTO implements Serializable{
	
	private static final long serialVersionUID = 5083781499116378277L;
	private int id;
	private String name;
	private String address;
	private String contact_ph;
	
	public AuthorDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_ph() {
		return contact_ph;
	}

	public void setContact_ph(String contact_ph) {
		this.contact_ph = contact_ph;
	}
	

}
