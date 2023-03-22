package PVBClothing.Entity;

public class InvoiceDetail {
	private long id_InvoiceDetail;
	private long id_Product;
	private long id_Invoice;
	private int quanty;
	private double total;

	public InvoiceDetail() {
		super();
	}

	public long getId_InvoiceDetail() {
		return id_InvoiceDetail;
	}

	public void setId_InvoiceDetail(long id_InvoiceDetail) {
		this.id_InvoiceDetail = id_InvoiceDetail;
	}

	public long getId_Product() {
		return id_Product;
	}

	public void setId_Product(long id_Product) {
		this.id_Product = id_Product;
	}

	public long getId_Invoice() {
		return id_Invoice;
	}

	public void setId_Invoice(long id_Invoice) {
		this.id_Invoice = id_Invoice;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
