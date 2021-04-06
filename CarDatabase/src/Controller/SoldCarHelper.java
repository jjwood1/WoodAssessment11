package Controller;

import model.SoldCar;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
public class SoldCarHelper {
	static EntityManagerFactory fact = Persistence.createEntityManagerFactory("WebShoppingList");
	public void insertItem(SoldCar sc)
	{
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		Manager.persist(sc);
		Manager.getTransaction().commit();
		Manager.close();		
	}
	public List<SoldCar> showAllSoldCars()
	{
		EntityManager Manager = fact.createEntityManager();
		List<SoldCar>Everything = Manager.createQuery("SELECT s FROM SoldCar s").getResultList();
		return Everything;		
	}
	public void updateSoldCar(SoldCar c) {
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		Manager.merge(c);
		Manager.getTransaction().commit();
		Manager.close();
	}	
	public SoldCar searchForSoldCarById(int c) {
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		SoldCar found = Manager.find(SoldCar.class, c);
		Manager.close();
		return found;
	}
	public void deleteCar(SoldCar c)
	{
		EntityManager Manager = fact.createEntityManager();
		Manager.getTransaction().begin();
		
		TypedQuery<SoldCar> typedQuery = Manager.createQuery("select lis from SoldCar lis where lis.id = :selectedId", SoldCar.class);
		typedQuery.setParameter("selectedId", c.getId());

		typedQuery.setMaxResults(1);
		SoldCar result = typedQuery.getSingleResult();
		Manager.remove(result);
		Manager.getTransaction().commit();
		Manager.close();
	}
	public void cleanUp()
	{
		fact.close();
	}

}
