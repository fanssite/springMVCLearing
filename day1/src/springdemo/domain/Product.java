package springdemo.domain;
import java.io.Serializable;
public class Product implements Serializable{
	private static final long serialVersionUID = 748392348L;//确保后面反序列化出来的类来源于同一个类（如未显示定义则默认根据类信息自动定义）
	private String name;
	private String description;
	private float price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
	

	