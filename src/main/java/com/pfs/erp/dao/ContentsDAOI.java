package com.pfs.erp.dao;

import com.pfs.erp.domain.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentsDAOI extends JpaRepository<Contents,Long> {

    Optional<Contents> findByName(String name);

}
