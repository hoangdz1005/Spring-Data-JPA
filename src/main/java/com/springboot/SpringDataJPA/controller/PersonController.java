package com.springboot.SpringDataJPA.controller;

import com.springboot.SpringDataJPA.model.Person;
import com.springboot.SpringDataJPA.repository.QueryCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PersonController {
    @Autowired
    QueryCreation queryCreation;

    @PostMapping("/api/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok().body(queryCreation.save(person));
    }

}
