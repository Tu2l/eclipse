package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_map3")
public class Order {
	@Id
	private int id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="orders_map", joinColumns = @JoinColumn(name = "fk_order"), inverseJoinColumns = @JoinColumn(name = "fk_product"))
	private List<Product> products = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + "]";
	}

}
