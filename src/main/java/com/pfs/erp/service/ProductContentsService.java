package com.pfs.erp.service;

import com.pfs.erp.config.Bootstrap;
import com.pfs.erp.customeException.DataNotFoundException;
import com.pfs.erp.dao.ContentsDAOI;
import com.pfs.erp.dao.ProductContentsDAOI;
import com.pfs.erp.dao.ProductDAOI;
import com.pfs.erp.domain.Contents;
import com.pfs.erp.domain.Product;
import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.dto.ProductContentsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductContentsService {

    @Autowired
    private ProductContentsDAOI productContentsDAOI;

    @Autowired
    private ProductDAOI productDAOI;

    @Autowired
    private ContentsDAOI contentsDAOI;

    public List<ProductContents> getList(){
        return productContentsDAOI.findAll();
    }

    public ProductContents save(ProductContentsDTO productContentsDTO){

        Optional<ProductContents> pco = productContentsDAOI.findByProductNameAndContentsName(productContentsDTO.getProductName(),productContentsDTO.getContentsName());

        if(!pco.isPresent()){
            Optional<Product> productOptional = productDAOI.findByName(productContentsDTO.getProductName());
            Optional<Contents> contentsOptional = contentsDAOI.findByName(productContentsDTO.getContentsName());
            if(productOptional.isPresent() && contentsOptional.isPresent()){
                ProductContents productContents = new ProductContents(productOptional.get(),contentsOptional.get(),productContentsDTO.getWeight());

                if(productContentsDAOI.save(productContents)!=null){
                    updateProductPrice(productContents);
                }

                return productContents;
            }else {
                throw new DataNotFoundException(productContentsDTO.toString());
            }
        }

        return null;

    }


    public ProductContents update(Long id,ProductContentsDTO productContentsDTO){

        Optional<ProductContents> pco = productContentsDAOI.findById(id);

        if(pco.isPresent()){
            ProductContents productContents = pco.get();
            productContents.setWeight(productContentsDTO.getWeight());
            if(productContentsDAOI.save(productContents)!=null){
                updateProductPrice(productContents);
            }
        }


        return null;

    }


    public ProductContents delete(Long id){

        if(id!=null){
            Optional<ProductContents> pco = productContentsDAOI.findById(id);
            if(pco.isPresent()){
                productContentsDAOI.delete(pco.get());
                return pco.get();
            }
        }

        return null;

    }


    public ProductContents getById(Long id){


        if(id!=null){
            Optional<ProductContents> optionalProductContents = productContentsDAOI.findById(id);
            if(optionalProductContents.isPresent()){
                return optionalProductContents.get();
            }
        }

        return null;

    }



    private void updateProductPrice(ProductContents productContents){


        Product product = productContents.getProduct();

        List<ProductContents> productContentsList = productContentsDAOI.findAllByProduct(product);

        product.setBasePrice(0.0);

        for(ProductContents pc : productContentsList){

            Contents c = pc.getContents();
            Double basePrice = product.getBasePrice() + (c.getPrice()*pc.getWeight());
            product.setBasePrice(basePrice);

        }

        product.setSellPrice((((product.getBasePrice()+product.getManufacturingCost())/ 100) * 50) + product.getBasePrice() );

        productDAOI.save(product);

    }


}
