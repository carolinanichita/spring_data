package cn.spring_data.project.repository;

import cn.spring_data.project.entity.Customer;
import cn.spring_data.project.entity.projection.CustomerFullName;
import cn.spring_data.project.entity.projection.CustomerInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>, CustomCustomerRepository, QuerydslPredicateExecutor<Customer> {

    List<Customer> findAllByFirstName(String firstName);

    Optional<Customer> findFirstByLastNameOrderByFirstNameDesc(String lastName);

    Customer findFirstByOrderByFirstNameAsc();

    Stream<Customer> readAllByOrderById();

    @Query("select p from Customer p order by p.id asc limit 1")
    Customer fetchFirstCustomerUsingQuery();

    Customer searchUsingNamedQuery(String lastName);

    CustomerFullName findFirstByOrderByFirstNameDesc();

    CustomerInfo findFirstByOrderByLastNameAsc();
}