package cn.spring_data.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Customer.searchUsingNamedQuery",
        query = "select c from Customer c where c.lastName = ?1 order by c.firstName desc limit 1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
}
