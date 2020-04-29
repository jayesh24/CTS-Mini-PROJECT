package com.cts.bb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bb.model.Product;

public interface productrepo extends JpaRepository<Product, Integer> {

}
