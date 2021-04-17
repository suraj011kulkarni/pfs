package com.pfs.erp.controller;

import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.dto.ProductContentsDTO;
import com.pfs.erp.service.ProductContentsService;
import com.pfs.erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping(value = "/productContents")
public class ProductContentsController {

    @Autowired
    private ProductContentsService productContentsService;

    @GetMapping(value = "/list")
    public Set<ProductContents> products(){
        return productContentsService.getList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductContents> getById(@PathVariable Long id){
        ProductContents productContents = productContentsService.getById(id);
        if(productContents==null){
            return new ResponseEntity<>(productContents,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(productContents,HttpStatus.OK);
        }

    }
    
    
    @PostMapping(value = "/save")
    public ResponseEntity<ProductContents> saveProductContents(@RequestBody ProductContentsDTO productContentsDTO){

        ProductContents productContents = productContentsService.save(productContentsDTO);

        return new ResponseEntity(productContents,HttpStatus.CREATED);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductContents> updateProductContents(@PathVariable Long id, @RequestBody ProductContentsDTO productContentsDTO){

        ProductContents productContents = productContentsService.update(id,productContentsDTO);

        return new ResponseEntity<>(productContents,HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ProductContents> deleteById(@PathVariable Long id){

        ProductContents productContents = productContentsService.delete(id);
        return new ResponseEntity<>(productContents,HttpStatus.ACCEPTED);

    }




}
