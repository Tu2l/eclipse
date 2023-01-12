package com.cg.app;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Department;
import com.cg.entity.Employee;
import com.cg.entity.Order;
import com.cg.entity.Product;

/**
 * Hello world!
 *
 */
public class ManyToManyBi {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Product p1 = new Product();
		p1.setPid(101);
		p1.setName("P1");

		Product p2 = new Product();
		p2.setPid(102);
		p2.setName("P2");

		Order order1 = new Order();
		order1.setId(12);
		order1.setName("order1");

		List<Order> orderList1 = new ArrayList<>();
		orderList1.add(order1);
	
		p1.setOrders(orderList1);
		p2.setOrders(orderList1);

		List<Product> productList1 = new ArrayList<>();
		productList1.add(p1);
		productList1.add(p2);

		order1.setProducts(productList1);

		Product p3 = new Product();
		p3.setPid(1010);
		p3.setName("P3");

		Order order2 = new Order();
		order2.setId(32);
		order2.setName("order2");

		List<Order> orderList2 = new ArrayList<>();
		orderList2.add(order2);
	
		p3.setOrders(orderList2);

		List<Product> productList2 = new ArrayList<>();
		productList2.add(p3);

		order2.setProducts(productList2);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);

		em.getTransaction().commit();

		System.out.println("Added");

		Order findOrder = em.find(Order.class, 32);
//		findOrder.getProducts().forEach(System.out::println);
		System.out.println(findOrder.getProducts());

		em.close();
		emf.close();

	}

}
