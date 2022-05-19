package com.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;private int shopId;
    private String name;
    private String description;
    private int price;
    private int discount;

    @Builder
	public Product(int shopId, String name, String description, int price, int discount) {
		this.shopId = shopId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}
}