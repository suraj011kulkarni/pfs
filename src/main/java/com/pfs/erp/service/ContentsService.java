package com.pfs.erp.service;

import com.pfs.erp.dao.ContentsDAOI;
import com.pfs.erp.domain.Contents;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentsService {

    @Autowired
    private ContentsDAOI contentsDAOI;

    public List<Contents> getList(){
        return contentsDAOI.findAll();
    }

    public Contents save(Contents contents){

        Optional<Contents> c1 = contentsDAOI.findByName(contents.getName());

        if(!c1.isPresent()){
            contentsDAOI.save(contents);
            return contents;
        }else{
            return null;
        }
    }


    public Contents update(Long id,Contents contents){

        if(id!=null && contents!=null){

            Optional<Contents> c1 = contentsDAOI.findById(id);

            if(c1.isPresent()){
                Contents updateContents = c1.get();
                BeanUtils.copyProperties(contents,updateContents,"id");
                contentsDAOI.save(updateContents);
                return updateContents;
            }
        }

        return null;
    }

    public Contents getById(Long id){

        if(id!=null){
            Optional<Contents> c1 = contentsDAOI.findById(id);

            if(c1.isPresent()){
                return c1.get();
            }
        }

        return null;
    }

    public Contents getByName(String name){

        if(name!=null){
            Optional<Contents> c1 = contentsDAOI.findByName(name);

            if(c1.isPresent()){
                return c1.get();
            }
        }

        return null;
    }


}
