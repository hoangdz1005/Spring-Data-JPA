package com.springboot.SpringDataJPA.controller;

import com.springboot.SpringDataJPA.model.Person;
import com.springboot.SpringDataJPA.repository.QueryNative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/querynative")
public class QueryNativeController {
    @Autowired
    QueryNative queryNative;

    @GetMapping("/firstname")
    public ResponseEntity<List<Person>> findByFirstName(@RequestParam(name = "firstName") String firstName) {
        return ResponseEntity.ok().body(queryNative.findByFirstName(firstName));
    }
    @GetMapping("/age")
    public ResponseEntity<List<Person>> findByAge() {
        return ResponseEntity.ok().body(queryNative.findByAge());
    }
    @GetMapping("/salary")
    public ResponseEntity<List<Person>> findBySalary() {
        return ResponseEntity.ok().body(queryNative.findBySalary());
    }

}
