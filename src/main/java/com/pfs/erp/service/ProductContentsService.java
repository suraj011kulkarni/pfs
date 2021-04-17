package com.pfs.erp.service;

import com.pfs.erp.config.Bootstrap;
import com.pfs.erp.domain.Contents;
import com.pfs.erp.domain.Product;
import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.domain.ProductContents;
import com.pfs.erp.dto.ProductContentsDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductContentsService {


    public Set<ProductContents> getList(){
        return Bootstrap.productContents;
    }

    public ProductContents save(ProductContentsDTO productContentsDTO){

        ProductContents pc1 = Bootstrap.getByProductNameAndContentsName(productContentsDTO.getProductName(),productContentsDTO.getContentsName());

        if(pc1==null){
            Product product = Bootstrap.getProductByName(productContentsDTO.getProductName());
            Contents contents = Bootstrap.getContentByName(productContentsDTO.getContentsName());
            pc1 = new ProductContents(product,contents,productContentsDTO.getWeight());
            Bootstrap.productContents.add(pc1);
            return pc1;
        }else{
            // TODO: throw an error as record already exist
            return null;
        }
    }


    public ProductContents update(Long id,ProductContentsDTO productContentsDTO){

        ProductContents pc1 = Bootstrap.getProductContentsById(id);

        if(pc1!=null){
            pc1.setWeight(productContentsDTO.getWeight());
            return pc1;
        }else{
            // TODO: throw an error as record already exist
            return null;
        }
    }


    public ProductContents delete(Long id){

        ProductContents pc1 = Bootstrap.getProductContentsById(id);
        if(pc1!=null){
            Bootstrap.productContents.remove(pc1);
            return pc1;
        }else{
            // TODO: throw an error as record already exist
            return null;
        }

    }


    public ProductContents getById(Long id){

        ProductContents pc1 = Bootstrap.getProductContentsById(id);
        if(pc1!=null){
            return pc1;
        }else{
            // TODO: throw an error as record not found
            return null;
        }
    }


}
