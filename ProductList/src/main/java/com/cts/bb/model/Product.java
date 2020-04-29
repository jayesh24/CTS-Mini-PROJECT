package com.cts.bb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public @Data class Product {
	@Id
	private int pid;
	
	@Column(name = "pname")
	private String name;

	@Column(name = "pdesc")
	private String desc;
	
	@Column(name = "pprice")
	private int price;
}
