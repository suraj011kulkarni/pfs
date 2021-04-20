package com.pfs.erp.service;

import com.pfs.erp.config.Bootstrap;
import com.pfs.erp.dao.ProductDAOI;
import com.pfs.erp.domain.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductDAOI productDAOI;

    public List<Product> getList(){
        return productDAOI.findAll();
    }

    public Product save(Product product){

        Optional<Product> p1 = productDAOI.findByName(product.getName());

        if(!p1.isPresent()){
            productDAOI.save(product);
            return product;
        }else{
            return null;
        }
    }


    public Product update(Long id,Product product){

        Optional<Product> p1  = productDAOI.findById(id);

        if(p1.isPresent()){
            Product productObject = p1.get();
            BeanUtils.copyProperties(product,productObject,"id","sellPrice","basePrice");
            productDAOI.save(productObject);
            return productObject;
        }else{
            return null;
        }
    }

    public Product getById(Long id){

        Optional<Product> p1  = productDAOI.findById(id);

        if(p1.isPresent()){

            return p1.get();
        }else{
            return null;
        }
    }

    public Product getByName(String name){

        Optional<Product> p1 = productDAOI.findByName(name);

        if(p1.isPresent()){
            return p1.get();
        }else{
            return null;
        }
    }


}
