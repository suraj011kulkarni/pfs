package com.pfs.erp.controller;

import com.pfs.erp.customeException.DataAlreadyExistingException;
import com.pfs.erp.customeException.DataNotFoundException;
import com.pfs.erp.customeException.ValidationException;
import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.dto.ProductContentsDTO;
import com.pfs.erp.service.ProductContentsService;
import com.pfs.erp.service.ProductService;
import com.pfs.erp.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/productContents")
public class ProductContentsController {

    @Autowired
    private ProductContentsService productContentsService;

    @GetMapping(value = "/list")
    public List<ProductContents> products(){
        return productContentsService.getList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductContents> getById(@PathVariable Long id){
        ProductContents productContents = productContentsService.getById(id);
        if(productContents==null){
            throw new DataNotFoundException("id "+id!=null?id.toString():"null");
        }else{
            return new ResponseEntity<>(productContents,HttpStatus.OK);
        }

    }
    
    
    @PostMapping(value = "/save")
    public ResponseEntity<ProductContents> saveProductContents(@Valid @RequestBody ProductContentsDTO productContentsDTO, BindingResult br){

        if(!br.hasErrors()){
            ProductContents productContents = productContentsService.save(productContentsDTO);
            if(productContents==null){
                throw new DataAlreadyExistingException(productContentsDTO.toString());
            }else{
                return new ResponseEntity(productContents,HttpStatus.CREATED);
            }

        }else{
            throw new ValidationException(CommonUtil.getErrorMessage(br.getFieldErrors()));
        }

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductContents> updateProductContents(@PathVariable Long id, @Valid @RequestBody ProductContentsDTO productContentsDTO,BindingResult br){

        if(!br.hasErrors()){
            ProductContents productContents = productContentsService.update(id,productContentsDTO);
            if(productContents==null){
                throw new DataNotFoundException("id "+id);
            }else{
                return new ResponseEntity<>(productContents,HttpStatus.OK);
            }

        }else {
            throw new ValidationException(CommonUtil.getErrorMessage(br.getFieldErrors()));
        }

    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ProductContents> deleteById(@PathVariable Long id){

        ProductContents productContents = productContentsService.delete(id);
        if(productContents==null){
            throw new DataNotFoundException("id "+id);
        }

        return new ResponseEntity<>(productContents,HttpStatus.ACCEPTED);

    }




}
