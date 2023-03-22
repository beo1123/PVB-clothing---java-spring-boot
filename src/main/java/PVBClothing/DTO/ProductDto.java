package PVBClothing.DTO;

import java.util.Date;

public class ProductDto {
	private long id_Product;
	private int id_Cat;
	private String size;
	private String name;
	private double price;
	private int sale;
	private boolean hightlight;
	private boolean new_product;
	private String description;
	private int id_Color;
	private String name_color;
	private String code_color;
	private String img;
	private Date create_at;
	private Date update_at;
	
	public ProductDto() {
		super();
	}

	public long getId_Product() {
		return id_Product;
	}

	public void setId_Product(long id_Product) {
		this.id_Product = id_Product;
	}

	public int getId_Cat() {
		return id_Cat;
	}

	public void setId_Cat(int id_Cat) {
		this.id_Cat = id_Cat;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public boolean isHightlight() {
		return hightlight;
	}

	public void setHightlight(boolean hightlight) {
		this.hightlight = hightlight;
	}

	public boolean isNew_product() {
		return new_product;
	}

	public void setNew_product(boolean new_product) {
		this.new_product = new_product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId_Color() {
		return id_Color;
	}

	public void setId_Color(int id_Color) {
		this.id_Color = id_Color;
	}

	public String getName_color() {
		return name_color;
	}

	public void setName_color(String name_color) {
		this.name_color = name_color;
	}

	public String getCode_color() {
		return code_color;
	}

	public void setCode_color(String code_color) {
		this.code_color = code_color;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	
	
	
	
	
	
}
