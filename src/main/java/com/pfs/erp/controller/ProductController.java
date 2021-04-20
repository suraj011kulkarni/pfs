package com.pfs.erp.controller;

import com.pfs.erp.customeException.DataAlreadyExistingException;
import com.pfs.erp.customeException.DataNotFoundException;
import com.pfs.erp.customeException.ValidationException;
import com.pfs.erp.domain.Product;
import com.pfs.erp.service.ProductService;
import com.pfs.erp.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public List<Product> products(){
        return productService.getList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product = productService.getById(id);
        if(product==null){
            throw new DataNotFoundException("id "+id);
        }else{
            return new ResponseEntity<>(product,HttpStatus.OK);
        }

    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name){
        Product product = productService.getByName(name);
        if(product==null){
            throw new DataNotFoundException("name "+name !=null ? name :"");
        }else{
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product, BindingResult be){

        if(!be.hasErrors()){
            Product product1 =  productService.save(product);

            if(product1==null){
                throw new DataAlreadyExistingException("product "+product!=null?product.toString():"");
            }else {
                return new ResponseEntity(product1,HttpStatus.OK);
            }
        }else{
            throw new ValidationException(CommonUtil.getErrorMessage(be.getFieldErrors()));
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product, BindingResult br){

        if(!br.hasErrors()){

            Product updatedProduct = productService.update(id,product);

            if(updatedProduct==null){
                throw new DataNotFoundException("id "+id);
            }else{
                return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
            }

        }else{
            throw new ValidationException(CommonUtil.getErrorMessage(br.getFieldErrors()));
        }

    }

}
