package com.containerize.restapidocker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity

@Table(name = "item")

@NamedQueries({

    @NamedQuery(name = "Item.findAll", 

    query = "SELECT i FROM Item i"),

    @NamedQuery(name = "Item.findByName", 

    query = "SELECT i FROM Item i WHERE i.itemName = :name"),

    @NamedQuery(name = "Item.findByPrice", 

    query = "SELECT i FROM Item i WHERE i.itemPrice = :price")

})

public class Item {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
 
    private String itemName;

    private Double itemPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
 
   

}


