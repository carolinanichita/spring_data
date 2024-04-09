package cn.spring_data.project.repository;

import cn.spring_data.project.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomCustomerRepository {
    Customer findCustomerCustom(String firstName, String lastName);
}
