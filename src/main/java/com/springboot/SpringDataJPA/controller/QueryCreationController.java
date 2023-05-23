package com.springboot.SpringDataJPA.controller;

import com.springboot.SpringDataJPA.model.Person;
import com.springboot.SpringDataJPA.repository.QueryCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/querycreation")
public class QueryCreationController {
    @Autowired
    QueryCreation queryCreation;

    @GetMapping("/firstName")
    public List<Person> getPersonByFirstName(@RequestParam(name = "firstName") String firstName) {
        return queryCreation.findByFirstName(firstName);
    }

    @GetMapping("/lastName")
    public List<Person> getPersonByLastName(@RequestParam(name = "lastName") String lastName) {
        return queryCreation.findByLastName(lastName);
    }

    @GetMapping("/ageequals/{age}")
    public ResponseEntity<List<Person>> findByAgeEquals(@PathVariable int age) {
        return ResponseEntity.ok().body(queryCreation.findByAgeEquals(age));
    }

    @GetMapping("/salarygreater/{salary}")
    public ResponseEntity<List<Person>> findBySalaryGreaterThan(@PathVariable double salary) {
        return ResponseEntity.ok().body(queryCreation.findBySalaryLessThan(salary));
    }

    @GetMapping("/filtername")
    public ResponseEntity<List<Person>> findByFirstNamrOrLastName(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        return ResponseEntity.ok().body(queryCreation.findByFirstNameOrLastName(firstName, lastName));
    }

    @GetMapping("/sortname")
    public ResponseEntity<List<Person>> findByFirstNameOrderByLastNameAsc(@RequestParam(name = "firstName") String firstName) {
        return ResponseEntity.ok().body(queryCreation.findByFirstNameOrderByLastNameAsc(firstName));
    }
    @GetMapping("/limitname")
    public ResponseEntity<List<Person>> findTop2ByFirstName(@RequestParam(name = "firstName") String firstName) {
        return ResponseEntity.ok().body(queryCreation.findTop2ByFirstName(firstName));
    }

}