package bookmanagement.models;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class BookRequestDTO implements Serializable{
	private static final long serialVersionUID = 1362367032774698282L;
	  
	@NotEmpty
	private String code;
	@NotEmpty
	private String name;
	@Range(min=0,max=5000)
	private double price;
	
	
	
	
	private int author_id;
	
	

	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
