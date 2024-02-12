package model;

public class PizzaOrder {
	
	private String size;
	private String crustType;
	private String[] toppings;
	private double quantity;
	
	public PizzaOrder(String size,String crustType, String[] toppings,double quantity) {
		setSize(size);
		setCrustType(crustType);
		setToppings(toppings);	
		setQuantity(quantity);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCrustType() {
		return crustType;
	}

	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}

	public String[] getToppings() {
		return toppings;
	}

	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

		

}
