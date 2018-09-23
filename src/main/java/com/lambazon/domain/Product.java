package com.lambazon.domain;

public class Product {
	
	private Integer id;
	private String name, description, details;
	private int quantity;
	private double price;
	private double priceTotal;
	public Product(int id, int quantity, double price, String name, String description) {
		setId(id);
		setQuantity(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);
		setInventoryPrice( price, quantity);
	    }

	public Integer getId() { return id;	}

	public void setId(Integer id) {	this.id = id; }

	public String getName() { return name;	}

	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description;}

	public String getDetails() { return details; }

	public void setDetails(String details) { this.details = details; }

	public int getQuantity() { return quantity;	}

    /**
     * Quantity lower than 0 = 0
     * @param quantity
     */

	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	    if(this.quantity <= 0)
	        this.quantity = 0;
    }

	public double getPrice() { return price; }

    /**
     * Price higher than 1000 = 1000
     * @param price
     */

	public void setPrice(double price) {
	    this.price = price;
	    if (this.price < 0.0)
	        this.price = 0.0;
	    else if (this.price > 1000.0)
	        this.price = 1000.0;


    }

	public double getInventoryPrice()
	{
		return priceTotal;

	}

	/**
	 * Sum of the price and quantity. Integration of Set InventoryPrice.
	 * @param price
	 * @param quantity
	 * @return
	 */

	public double setInventoryPrice(double price, int quantity)
	{
		price = getPrice();
		quantity = getQuantity();
		priceTotal = price* quantity;
		return priceTotal;
	}
}
