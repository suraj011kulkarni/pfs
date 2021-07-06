package com.pfs.erp.service;

import com.pfs.erp.dao.ContentsDAOI;
import com.pfs.erp.dao.PurchaseDAOI;
import com.pfs.erp.domain.Contents;
import com.pfs.erp.domain.Purchase;
import com.pfs.erp.dto.PurchaseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {


    @Autowired
    private PurchaseDAOI purchaseDAOI;

    @Autowired
    private ContentsDAOI contentsDAOI;

    public List<Purchase> getPurchaseList(){
        return purchaseDAOI.findAll();
    }

    public Purchase save(PurchaseDTO purchaseDTO){

        if(purchaseDTO.getContentsName()!=null){
            Purchase purchase = new Purchase();
            Optional<Contents> contentsOptional = contentsDAOI.findByName(purchaseDTO.getContentsName());
            if(contentsOptional.isPresent()){
                BeanUtils.copyProperties(purchaseDTO,purchase,"contentsName");
                purchase.setContents(contentsOptional.get());
                purchaseDAOI.save(purchase);

                // TODO: update stock

                return purchase;
            }


        }

        return null;

    }


    public Purchase update(Long id, PurchaseDTO purchaseDTO){

        if(id!=null){

            Optional<Purchase> purchaseOptional = purchaseDAOI.findById(id);
            Optional<Contents> contentsOptional = contentsDAOI.findByName(purchaseDTO.getContentsName());

            if(purchaseOptional.isPresent() && contentsOptional.isPresent()){

                Purchase purchase = purchaseOptional.get();
                BeanUtils.copyProperties(purchaseDTO,purchase,"contentsName");
                purchase.setContents(contentsOptional.get());
                purchaseDAOI.save(purchase);

                // TODO: update stock
                return purchase;
            }


        }



        return null;
    }

    public Purchase getById(Long id){

        if(id!=null){
            Optional<Purchase> purchaseOptional = purchaseDAOI.findById(id);
            if(purchaseOptional.isPresent()){
                return purchaseOptional.get();
            }

        }
        return null;
    }

    public Purchase deleteById(Long id){

        if(id!=null){
            Optional<Purchase> purchaseOptional = purchaseDAOI.findById(id);
            if(purchaseOptional.isPresent()){
                Purchase purchase = purchaseOptional.get();
                purchaseDAOI.delete(purchase);
                return purchase;
            }

        }
        return null;
    }



}
