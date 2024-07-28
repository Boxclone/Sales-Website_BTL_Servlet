package entity;

public class Cart {
	private int id;
	private int prodID;
	private int quantity;
	private int accID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdID() {
		return prodID;
	}
	public void setProdID(int prodID) {
		this.prodID = prodID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	
	public Cart(int id, int prodID, int quantity, int accID) {
		super();
		this.id = id;
		this.prodID = prodID;
		this.quantity = quantity;
		this.accID = accID;
	}
	
	public Cart() {
		super();
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", prodID=" + prodID + ", quantity=" + quantity + ", accID=" + accID + "]";
	}
	
}
