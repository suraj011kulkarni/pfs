package com.pfs.erp.service;

import com.pfs.erp.config.Bootstrap;
import com.pfs.erp.domain.Contents;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContentsService {


    public Set<Contents> getList(){
        return Bootstrap.contentsSet;
    }

    public Contents save(Contents contents){

        Contents c1 = Bootstrap.getContentByName(contents.getName());

        if(c1==null){
            Bootstrap.contentsSet.add(contents);
            return contents;
        }else{
            // TODO: throw an error as record already exist
            return null;
        }
    }


    public Contents update(Long id,Contents contents){

        Contents c1 = Bootstrap.getContentById(id);

        if(c1!=null){
            BeanUtils.copyProperties(contents,c1,"id");
            return contents;
        }else{
            // TODO: throw an error as record already exist
            return null;
        }
    }

    public Contents getById(Long id){

        Contents c1 = Bootstrap.getContentById(id);

        if(c1!=null){
            return c1;
        }else{
            // TODO: throw an error as record not found
            return null;
        }
    }

    public Contents getByName(String name){

        Contents c1 = Bootstrap.getContentByName(name);

        if(c1!=null){
            return c1;
        }else{
            // TODO: throw an error as record not found
            return null;
        }
    }


}
