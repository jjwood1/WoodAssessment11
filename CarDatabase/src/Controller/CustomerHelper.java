package Controller;
import java.util.List;
import model.Customer;
import model.SoldCar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
public class CustomerHelper {
	static EntityManagerFactory fact = Persistence.createEntityManagerFactory("WebShoppingList");
	public void insertItem(Customer sc)
	{
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		Manager.persist(sc);
		Manager.getTransaction().commit();
		Manager.close();		
	}
}
