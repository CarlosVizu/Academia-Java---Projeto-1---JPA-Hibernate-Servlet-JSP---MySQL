package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtoteste")
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private int barcode;
	@Column(nullable = false)
	private String name;
	@Column
	private String category;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private int quantity;
	
	public Product() {
		
	}
	
	public Product(int barcode, String name, String category, float price, int quantity) 
	{
	this.barcode = barcode;
	this.name = name;
	this.category = category;
	this.price = (float) price;
	this.quantity = quantity;
	}
	
	public Product(int id, int barcode, String name, String category, float price, int quantity) 
	{
	this.id = id;
	this.barcode = barcode;
	this.name = name;
	this.category = category;
	this.price = (float) price;
	this.quantity = quantity;
	}
	
	@Override
	public String toString() 
	{
		return "Product [id=" + id + ", barcode=" + barcode + ", name=" + name + ", category=" + category + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}