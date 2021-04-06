package model;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table (name="sold_car")
public class SoldCar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="YEAR")
	private String year;
	@Column(name="OWNER")
	private String owner;
	@Column(name="DATE_SOLD")
	private LocalDate dateSold;
	//@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	public SoldCar()
	{
		super();
	}
	public SoldCar(int id)
	{
		super();
		this.id = id;
	}
	public SoldCar(String name, String year, LocalDate dateSold)
	{
		this.name = name;
		this.year = year;

		this.dateSold = dateSold;
		
	}
	public SoldCar(String name, String year, String owner, LocalDate dateSold)
	{
		this.name = name;
		this.year = year;
		this.owner = owner;
		this.dateSold = dateSold;
		
	}
	public SoldCar(String name, String year, LocalDate dateSold, Customer customer)
	{
		this.name = name;
		this.year = year;
		//this.owner = owner;
		this.dateSold = dateSold;
		this.customer = customer;
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getYear()
	{
		return year;
	}
	public String getOwner()
	{
		return customer.getcustomerName();
	}
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	public LocalDate getDateSold()
	{
		return dateSold;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setYear(String year)
	{
		this.year = year;
	}
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public void setDateSold(LocalDate dateSold)
	{
		this.dateSold = dateSold;
	}
}
