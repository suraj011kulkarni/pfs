package com.pfs.erp.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.pfs.erp.config.Bootstrap;
import com.pfs.erp.domain.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

@Service
public class ProductService {


    public Set<Product> getList(){
        return Bootstrap.productSet;
    }

    public Product save(Product product){

        Product p1 = Bootstrap.getProductByName(product.getName());

        if(p1==null){
            Bootstrap.productSet.add(product);
            return product;
        }else{
            // TODO: throw an error as record already exist
            return null;
        }
    }


    public Product update(Long id,Product product){

        Product p1 = Bootstrap.getProductById(id);

        if(p1!=null){
            BeanUtils.copyProperties(product,p1,"id","sellPrice","basePrice");
            return product;
        }else{
            // TODO: throw an error as record already exist
            return null;
        }
    }

    public Product getById(Long id){

        Product p1 = Bootstrap.getProductById(id);

        if(p1!=null){
            return p1;
        }else{
            // TODO: throw an error as record not found
            return null;
        }
    }

    public Product getByName(String name){

        Product p1 = Bootstrap.getProductByName(name);

        if(p1!=null){
            return p1;
        }else{
            // TODO: throw an error as record not found
            return null;
        }
    }


}
