package com.pfs.erp.controller;

import com.pfs.erp.domain.Contents;
import com.pfs.erp.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping(value = "/contents")
public class ContentController {

    @Autowired
    private ContentsService contentsService;

    @GetMapping(value = "/list")
    public Set<Contents> contents(){
        return contentsService.getList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Contents> getById(@PathVariable Long id){
        Contents contents = contentsService.getById(id);
        if(contents==null){
            return new ResponseEntity<>(contents,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(contents,HttpStatus.OK);
        }

    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<Contents> getByName(@PathVariable String name){
        Contents contents = contentsService.getByName(name);
        if(contents==null){
            return new ResponseEntity<>(contents,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(contents,HttpStatus.OK);
        }
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Contents> saveContents(@RequestBody Contents contents){

        contentsService.save(contents);


        return new ResponseEntity(contents,HttpStatus.OK);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Contents> updateContents(@PathVariable Long id, @RequestBody Contents contents){

        contentsService.update(id,contents);

        return new ResponseEntity<>(contents,HttpStatus.OK);

    }




}
