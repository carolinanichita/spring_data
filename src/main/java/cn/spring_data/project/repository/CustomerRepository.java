package cn.spring_data.project.repository;

import cn.spring_data.project.entity.Customer;
import cn.spring_data.project.entity.projection.CustomerFullName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>, CustomCustomerRepository {

    List<Customer> findAllByFirstName(String firstName);

    Optional<Customer> findFirstByLastNameOrderByFirstNameDesc(String lastName);

    Customer findFirstByOrderByFirstNameAsc();

    Stream<Customer> readAllByOrderByIdDesc();

    @Query("select c from Customer c order by c.id asc limit 1")
    Customer fetchFirstCustomerUsingQuery();

    Customer searchUsingNamedQuery(String lastName);
}