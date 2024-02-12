package model;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
	private Map<PizzaOrder,Customer> orders;
	
	public OrderManager() {
		orders=new HashMap<>();
	}

	public void placeOrder(PizzaOrder order,Customer customer) {
		orders.put(order,customer);
	}
	public void removeOrder(PizzaOrder order) {
        orders.remove(order);
    }
}
