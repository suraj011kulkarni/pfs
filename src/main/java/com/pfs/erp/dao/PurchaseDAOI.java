package com.pfs.erp.dao;

import com.pfs.erp.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseDAOI extends JpaRepository<Purchase,Long> {


    Optional<Purchase> findByContentsName(String name);
}
