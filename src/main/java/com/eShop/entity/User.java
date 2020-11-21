package com.eShop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String password;
	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;
	private String phone;
	@ManyToMany(cascade = CascadeType.ALL)
	private Role roles;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ShoppingCart> cart;

}
