package com.pfs.erp.dao;

import com.pfs.erp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDAOI extends JpaRepository<Product,Long> {

    @Override
    List<Product> findAll();

    Optional<Product> findByName(String name);
}
