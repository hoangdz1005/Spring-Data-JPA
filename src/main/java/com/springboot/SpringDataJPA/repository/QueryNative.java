package com.springboot.SpringDataJPA.repository;

import com.springboot.SpringDataJPA.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueryNative extends JpaRepository<Person, Long> {

    // Tìm person từ firstName
    @Query(value = "select * from persons p where p.first_name =?1", nativeQuery = true)
    List<Person> findByFirstName(String firstname);

    // Tìm ngưới lớn hơn 25 tuổi
    @Query(value = "select * from persons p where p.age > 25 ", nativeQuery = true)
    List<Person> findByAge();

    // Tìm người có lương trong khoảng từ 1300-2000
    @Query(value = "select * from persons p where p.salary between 1300.0 and 2000.0", nativeQuery = true)
    List<Person> findBySalary();
}
