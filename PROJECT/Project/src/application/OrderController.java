/**********************************************
Workshop 2
Course:APD545 - Semester-5
Last Name:Mulani
First Name:Yukti Manoj
ID:156809212
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:February 11, 2024
**********************************************/

package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import model.Customer;
import model.OrderManager;
import model.PizzaOrder;
import view.PizzaOrderView;

public class OrderController extends Application {
	
	private Customer customer;
	private OrderManager model;
	private PizzaOrder porder;
	private PizzaOrderView view;
	
	public OrderController() {
		model=new OrderManager();
		view=new PizzaOrderView(model);
		
	}
	
	
	private void handlePlaceOrderButtonPress(PizzaOrder porder,Customer customer) {
		model.placeOrder(porder, customer);
	}
	
	private void handleClearButtonPress() {
		model.removeOrder(porder);
	}
	
	private void displayOrderSummary() {
		double toppingCharge=0;
		double beforeTax=0;
		double Total=0;
		
		
		//calculate the toping charge
		int selectedToppingsCount = 0;
		int meat=0;
		String[] meatToppings = {"Ground Beef","Shredded Chicken","Griller Chicken","Pepperoni","Ham","Bacon"};
	    for (CheckBox checkBox : view.getToppingsCheckBoxes()) {
	        if (checkBox.isSelected()) {
	        	selectedToppingsCount++;
	        	//System.out.println(checkBox.getText());
	        	for(String meatTopping:meatToppings) {
	        		if(checkBox.getText().equalsIgnoreCase(meatTopping)) {
	        			meat++;
	        		}
	        	}
	            
	        }
	    }
	    toppingCharge=1.10*(selectedToppingsCount-meat)+2.15*meat;
	    RadioButton selectedSize=(RadioButton)view.getTg1().getSelectedToggle();
		//calculate before tax
		if(selectedSize.getText()=="Small-$7.00") {
			beforeTax=(7+toppingCharge)*Double.parseDouble(view.getTf3().getText());
		}else if(selectedSize.getText()=="Medium-$10.00") {
			beforeTax=(10+toppingCharge)*Double.parseDouble(view.getTf3().getText());
			System.out.println(Double.parseDouble(view.getTf3().getText()));
		}else if(selectedSize.getText()=="Large-$13.00") {
			beforeTax=(13+toppingCharge)*Double.parseDouble(view.getTf3().getText());
		}else if(selectedSize.getText()=="Extra Large-$15.00") {
			beforeTax=(15+toppingCharge)*Double.parseDouble(view.getTf3().getText());
		}
		
		
		//total after tax
		Total=(beforeTax*0.13)+beforeTax;
		
		view.getTa().setText("Customer Name: "+customer.getName()+"\n"
				+"Customer Phone: "+customer.getPhone()+"\n"
				+"Pizza Type: "+ porder.getCrustType()+"\n"
				+"Pizza Size: "+porder.getSize()+"\n"
				+"Quantity: "+porder.getQuantity()+"\n"
				+"Total before Tax: "+ beforeTax+"\n"
				+"Total to be paid: "+Total+"\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ps) throws Exception {
		// TODO Auto-generated method stub
		//event handlers
		//Place Order  Button Event Handler
		view.getBt2().setOnAction(new EventHandler<ActionEvent>() {


			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RadioButton selectedSize=(RadioButton)view.getTg1().getSelectedToggle();
		    	RadioButton selectedCrustType=(RadioButton)view.getTg2().getSelectedToggle();
		    	if (selectedSize == null || selectedCrustType == null||view.getTf()==null||view.getTf2().getText().isEmpty()||view.getTf3().getText().isEmpty()) {
		            // Display a message to the user
		            Alert alert = new Alert(Alert.AlertType.WARNING);
		            alert.setTitle("Order Validation");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select size,crust type and enter you details before placing the order.");
		            alert.showAndWait();
		            return; // Exit the method without processing the order
		        }else {
					customer=new Customer(view.getTf().getText(),view.getTf2().getText());
					porder=new PizzaOrder(selectedSize.getText(),selectedCrustType.getText(),view.getToppings(),Double.parseDouble(view.getTf3().getText()));
					handlePlaceOrderButtonPress(porder,customer);
					displayOrderSummary();
		        }
			}
			
		});
		
		//clear button event handler
		view.getBt1().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				handleClearButtonPress();
				//clear radio buttons
				view.getTg1().selectToggle(null);
				view.getTg2().selectToggle(null);
				
				//clear the check boxes
				for(CheckBox checkbox:view.getToppingsCheckBoxes()) {
					checkbox.setSelected(false);
				}
				//clear text fields and text area
				view.getTa().clear();
				view.getTf().clear();
				view.getTf2().clear();
				view.getTf3().clear();
			}
			
		});
		
		
		//set the scene
		view.setStyle("-fx-background-color: lightblue;");
		ps.setTitle("Promino's Pizza");
		ps.setResizable(true);
		ps.setScene(new Scene(view,900,600));
		ps.show();
		
	}
	
	

}
