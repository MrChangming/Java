package domain;
/**
* @Description
* @author MrChangMing
* @version 
* @data 2022��7��20��
*
*/
public class NoteBook implements Equipment{
	private String model;//�������ͺ�
	private double price;//�۸�
	

	public NoteBook() {
		super();
	}


	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String getDescription() {
		return model + "(" + price + ")";
	}
}
