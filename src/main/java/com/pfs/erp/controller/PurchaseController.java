package com.pfs.erp.controller;

import com.pfs.erp.customeException.DataNotFoundException;
import com.pfs.erp.customeException.ValidationException;
import com.pfs.erp.domain.Purchase;
import com.pfs.erp.dto.PurchaseDTO;
import com.pfs.erp.service.PurchaseService;
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

@RestController
@RequestMapping("/purchase")
public class PurchaseController {


    @Autowired
    private PurchaseService purchaseService;

    @GetMapping(value ="/list")
    public ResponseEntity<List<Purchase>> getList(){
        return new ResponseEntity<>(purchaseService.getPurchaseList(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Purchase> getById(Long id){

        Purchase purchase = purchaseService.getById(id);
        if(purchase==null){
            throw new DataNotFoundException("id "+id);
        }else{
            return new ResponseEntity<>(purchase,HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Purchase> deleteById(Long id){
        Purchase purchase = purchaseService.deleteById(id);
        if(purchase==null){
            throw new DataNotFoundException("id "+id);
        }else{
            return new ResponseEntity<>(purchase,HttpStatus.ACCEPTED);
        }
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Purchase> save(@Valid @RequestBody PurchaseDTO purchaseDTO, BindingResult br){

        if(!br.hasErrors()){

            Purchase purchase = purchaseService.save(purchaseDTO);
            if(purchase==null){
                throw new DataNotFoundException(purchaseDTO.toString());
            }else {
                return new ResponseEntity<>(purchase,HttpStatus.OK);
            }

        }else {
            throw new ValidationException(CommonUtil.getErrorMessage(br.getFieldErrors()));
        }


    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Purchase> update(@PathVariable Long id, @Valid @RequestBody PurchaseDTO purchaseDTO, BindingResult br){

        if(!br.hasErrors()){

            Purchase purchase = purchaseService.update(id,purchaseDTO);
            if(purchase==null){
                throw new DataNotFoundException(purchaseDTO.toString());
            }else {
                return new ResponseEntity<>(purchase,HttpStatus.OK);
            }

        }else {
            throw new ValidationException(CommonUtil.getErrorMessage(br.getFieldErrors()));
        }
    }


   /* @DeleteMapping(value = "/{id}")
    public ResponseEntity<Purchase> delete(@PathVariable Long id){

        Purchase purchase = purchaseService.deleteById(id);
        if(purchase==null){
            throw new DataNotFoundException("id "+id);
        }else {
            return new ResponseEntity<>(purchase,HttpStatus.OK);
        }
    }*/



}
