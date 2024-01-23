package com.shoxiyy.busi.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLeaderId(Long id);
    @Query(value = "SELECT * FROM Customers e WHERE LOWER(e.first_name) LIKE %:name% OR LOWER(e.last_name) LIKE %:name% " +
            "OR (e.first_name) LIKE %:name% OR (e.last_name) LIKE %:name%" +
            "OR UPPER(e.first_name) LIKE %:name% OR UPPER(e.last_name) LIKE %:name%",
            nativeQuery = true)
    List<Customer> findByName(@Param("name") String name);

    @Query("SELECT sum(e.price) from Customer e")
    Long sumPrice();

}
