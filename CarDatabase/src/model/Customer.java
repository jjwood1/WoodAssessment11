package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table (name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private int id;
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	public Customer()
	{
		super();
	}
	public Customer(String customerName)
	{
		super();
		this.customerName = customerName;
	}
	public String getcustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String owner)
	{
		this.customerName = owner;
	}
	
}
