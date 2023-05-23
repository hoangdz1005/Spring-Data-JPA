package com.springboot.SpringDataJPA.repository;

import com.springboot.SpringDataJPA.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface QueryCreation extends JpaRepository<Person,Long> {

   // Tìm kiếm theo tên thuộc tính
    List<Person> findByFirstName(String firstName);
    List<Person> findByLastName(String lastName);

    // Tìm kiếm sử dụng toán tử so sánh
    List<Person> findByAgeEquals(int age);
    List<Person> findBySalaryGreaterThan(double salary);
    List<Person> findBySalaryLessThan(double salary);

    // Tìm kiếm với các điều kiện kết hợp
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);
    List<Person> findByFirstNameOrLastName(String firstName, String lastName);


    // Sắp xếp kết quả
    List<Person> findByFirstNameOrderByLastNameAsc(String firstName);

    // Giới hạn số lượng trả về
    Person findFirstByLastName(String lastName);
    List<Person> findTop2ByFirstName(String firstName);



}
