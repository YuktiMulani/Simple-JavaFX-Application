package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.OrderManager;

public class PizzaOrderView extends Pane{
	private OrderManager model;
	private TextField tf;
	private TextField tf2;
	private TextField tf3;
	private TextArea ta;
	private Label lb1;
	private Label lb2;
	private Label lb3;
	private Label lb4;
	private Label lb5;
	private Label lb6;
	private Label lb7;
	private Label lb8;
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private ToggleGroup tg1;
	private ToggleGroup tg2;
	private RadioButton r1;
	private RadioButton r2;
	private RadioButton r3;
	private RadioButton r4;
	private RadioButton d1;
	private RadioButton d2;
	private RadioButton d3;
	private CheckBox c;
	private CheckBox c1;
	private String[] toppings={"PineApple","Extra Cheese","Dried Shrimp","Mushrooms","Anchovies","Sun Dries Tomatoes","Dacon","Spinach","Roasted Garlic","Jalepeno","Ground Beef","Shredded Chicken","Grilled Chicken","Pepperoni","Ham","Bacon"};;
	private List<CheckBox> toppingsCheckBoxes;
	private Label prominos;
	
	public PizzaOrderView(OrderManager m) {
		
		model=m;
		
		//create and place the labels 
		lb1= new Label("Select the Pizza Size");
		lb1.relocate(10,10);
		lb2=new Label("Select the Crust Type");
		lb2.relocate(10, 120);
		lb3=new Label("Toppings[Extra $1.10 for every topping]");
		lb3.relocate(10, 210);
		lb4=new Label("(Meat type toppings cost $2.15 Each)");
		lb4.relocate(10, 430);
		lb5=new Label("Customer Name");
		lb5.relocate(300, 10);
		lb6=new Label("Customer Phone Number");
		lb6.relocate(500, 10);
		lb7= new Label("Pizza Quantity");
		lb7.relocate(700, 10);
		lb8=new Label("Order Summary");
		lb8.relocate(300, 70);
		prominos=new Label("Promino's Pizza");
		prominos.relocate(250,400);
		prominos.setFont(new Font("Times New Roman",96));
		prominos.setTextFill(Color.ALICEBLUE);
		
		//buttons
		bt1=new Button("Clear");
		bt1.relocate(300, 300);
		bt2=new Button("Place Order");
		bt2.relocate(500, 300);
		
		// toggle group
		tg1=new ToggleGroup();
		tg2=new ToggleGroup();
		
		//radio buttons
		r1=new RadioButton("Small-$7.00");
		r1.relocate(10, 30);
		r2=new RadioButton("Medium-$10.00");
		r2.relocate(10, 50);
		r3=new RadioButton("Large-$13.00");
		r3.relocate(10, 70);
		r4=new RadioButton("Extra Large-$15.00");
		r4.relocate(10, 90);
		d1=new RadioButton("Normal");
		d1.relocate(10, 140);
		d2=new RadioButton("Thin");
		d2.relocate(10, 160);
		d3=new RadioButton("DeepDish");
		d3.relocate(10, 180);
		
		//add radio buttons to the toggle group-1
		r1.setToggleGroup(tg1);
		r2.setToggleGroup(tg1);
		r3.setToggleGroup(tg1);
		r4.setToggleGroup(tg1);
		d1.setToggleGroup(tg2);
		d2.setToggleGroup(tg2);
		d3.setToggleGroup(tg2);
		
		
		getChildren().addAll(lb1,r1,r2,r3,r4,lb2,d1,d2,d3,lb3);
		
		//create  check boxes
		toppingsCheckBoxes = new ArrayList<>();
		int location=230;
		for (int i =0;i<toppings.length-1;i++) {
			if(toppings[i]=="Ground Beef") {
				c=new CheckBox("Ground Beef");
				toppingsCheckBoxes.add(c);
				c.relocate(10, 450);
				getChildren().addAll(lb4,c);
				location=location+40;
				
			}
			else {
				c1= new CheckBox(toppings[i]);
				toppingsCheckBoxes.add(c1);
				c1.relocate(10, location);
				location=location+20;
				getChildren().add(c1);
				
			}
			
			//System.out.println(location);
		
		}
		
//		//image 
//		pizzaI=new ImageView("pizza.png");
//		pizzaI.relocate(400, 600);
		//text field
		tf=new TextField();
		tf.setPromptText("Enter Your Name");
		tf.relocate(300, 30);
		tf2=new TextField();
		tf2.setPromptText("Enter Your Phone Number");
		tf2.relocate(500, 30);
		tf3=new TextField();
		tf3.setPromptText("Enter the quantity of Pizzas");
		tf3.relocate(700, 30);
		
		//text area
		ta=new TextArea();
		ta.relocate(300, 100);
		ta.prefWidth(500);
			
		getChildren().addAll(lb5,tf,lb6,tf2,lb7,tf3,lb8,ta,bt1,bt2,prominos);
		
		
	}

	public OrderManager getModel() {
		return model;
	}

	public TextField getTf() {
		return tf;
	}

	public TextField getTf2() {
		return tf2;
	}

	public TextField getTf3() {
		return tf3;
	}

	public TextArea getTa() {
		return ta;
	}

	public Label getLb1() {
		return lb1;
	}

	public Label getLb2() {
		return lb2;
	}

	public Label getLb3() {
		return lb3;
	}

	public Label getLb4() {
		return lb4;
	}

	public Label getLb5() {
		return lb5;
	}

	public Label getLb6() {
		return lb6;
	}

	public Label getLb7() {
		return lb7;
	}

	public Label getLb8() {
		return lb8;
	}

	public Button getBt1() {
		return bt1;
	}

	public Button getBt2() {
		return bt2;
	}

	public ToggleGroup getTg1() {
		return tg1;
	}

	public ToggleGroup getTg2() {
		return tg2;
	}

	public RadioButton getR1() {
		return r1;
	}

	public RadioButton getR2() {
		return r2;
	}

	public RadioButton getR3() {
		return r3;
	}

	public RadioButton getR4() {
		return r4;
	}

	public RadioButton getD1() {
		return d1;
	}

	public RadioButton getD2() {
		return d2;
	}

	public RadioButton getD3() {
		return d3;
	}

	public CheckBox getC() {
		return c;
	}

	public CheckBox getC1() {
		return c1;
	}

	public String[] getToppings() {
		return toppings;
	}

	public List<CheckBox> getToppingsCheckBoxes() {
		return toppingsCheckBoxes;
	}
	
	
	
//	public void update() {
//		
//	}
	
	
}
