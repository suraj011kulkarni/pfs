package com.pfs.erp.dao;

import com.pfs.erp.domain.Product;
import com.pfs.erp.domain.ProductContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductContentsDAOI extends JpaRepository<ProductContents,Long> {

    Optional<ProductContents> findByProductNameAndContentsName(String productName, String contentName);
    List<ProductContents> findAllByProduct(Product p);

}
