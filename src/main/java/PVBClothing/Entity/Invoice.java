package PVBClothing.Entity;

public class Invoice {
	private long id_Invoice; 	
	private double totalPrice; 
	private int totalQuanty; 
	private String email; 
	private String full_Name; 
	private String phone; 
	private String address; 
	
	public Invoice() {
		super();
	}

	public long getId_Invoice() {
		return id_Invoice;
	}

	public void setId_Invoice(long id_Invoice) {
		this.id_Invoice = id_Invoice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalQuanty() {
		return totalQuanty;
	}

	public void setTotalQuanty(int totalQuanty) {
		this.totalQuanty = totalQuanty;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFull_Name() {
		return full_Name;
	}

	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
