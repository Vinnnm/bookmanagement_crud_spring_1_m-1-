package bookmanagement.models;

import java.io.Serializable;

public class BookResponseDTO implements Serializable{
	
	private static final long serialVersionUID = -5540164995734273231L;
	private String code;
	private String name;
	private double price;
	private String author;
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
