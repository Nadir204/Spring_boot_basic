package com.example.NumberGuessSql.Controller;

import com.example.NumberGuessSql.Service.PlayerService;
import com.example.NumberGuessSql.entity.PlayerEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService Playerservice;


    @PostMapping("/submit")
    public ResponseEntity<String> submitans(@RequestBody PlayerEntry newEntry){

        return Playerservice.Submitans1(newEntry);


    }






}
