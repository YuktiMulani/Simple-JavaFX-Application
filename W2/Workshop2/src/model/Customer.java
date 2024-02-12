package model;

public class Customer {
	private String customerName;
	private String customerPhone;
	
	public Customer(String customerName,String customerPhone) {
		setName(customerName);
		setPhone(customerPhone);
		
	}

	public String getName() {
		return customerName;
	}

	public void setName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return customerPhone;
	}

	public void setPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	

}
