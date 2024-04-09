package cn.spring_data.project.repository;

import cn.spring_data.project.entity.Customer;
import cn.spring_data.project.entity.projection.CustomerFullName;
import cn.spring_data.project.entity.projection.CustomerInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    CustomerFullName findFirstByOrderByFirstNameDesc();
    CustomerInfo findFirstByOrderByLastNameAsc();
}