package com.pfs.erp.controller;

import com.pfs.erp.domain.Product;
import com.pfs.erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public Set<Product> products(){
        return productService.getList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product = productService.getById(id);
        if(product==null){
            return new ResponseEntity<>(product,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(product,HttpStatus.OK);
        }

    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name){
        Product product = productService.getByName(name);
        if(product==null){
            return new ResponseEntity<>(product,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){

        productService.save(product);


        return new ResponseEntity(product,HttpStatus.OK);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){

        productService.update(id,product);

        return new ResponseEntity<>(product,HttpStatus.OK);

    }




}
