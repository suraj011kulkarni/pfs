package com.pfs.erp.controller;

import com.pfs.erp.customeException.DataAlreadyExistingException;
import com.pfs.erp.customeException.DataNotFoundException;
import com.pfs.erp.customeException.ValidationException;
import com.pfs.erp.domain.Contents;
import com.pfs.erp.service.ContentsService;
import com.pfs.erp.utility.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
@RequestMapping(value = "/contents")
public class ContentController {

    @Autowired
    private ContentsService contentsService;

    @GetMapping(value = "/list")
    public List<Contents> contents(){
        return contentsService.getList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Contents> getById(@PathVariable Long id){

        Contents contents = contentsService.getById(id);
        if(contents==null){
            throw new DataNotFoundException("id "+id);
        }else{
            return new ResponseEntity<>(contents,HttpStatus.OK);
        }

    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<Contents> getByName(@PathVariable String name){
        Contents contents = contentsService.getByName(name);
        if(contents==null){
            throw new DataNotFoundException("name "+name!=null ? name : "");
        }else{
            return new ResponseEntity<>(contents,HttpStatus.OK);
        }
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Contents> saveContents(@Valid @RequestBody Contents contents, BindingResult br){

        if(!br.hasErrors()){

            Contents contentsObj = contentsService.save(contents);

            if(contentsObj==null){
                throw new DataAlreadyExistingException(contents.toString());
            }else{
                return new ResponseEntity(contentsObj,HttpStatus.OK);
            }

        }else{
            throw new ValidationException(CommonUtil.getErrorMessage(br.getFieldErrors()));
        }

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Contents> updateContents(@PathVariable Long id, @Valid @RequestBody Contents contents,BindingResult br){

        if(!br.hasErrors()){
            Contents contents1 = contentsService.update(id,contents);
            if(contents1==null){
                throw new DataNotFoundException("id "+id!=null?id.toString():"0");
            }else{
                return new ResponseEntity<>(contents,HttpStatus.OK);
            }
        }else {
            throw new ValidationException(CommonUtil.getErrorMessage(br.getFieldErrors()));
        }
    }




}
