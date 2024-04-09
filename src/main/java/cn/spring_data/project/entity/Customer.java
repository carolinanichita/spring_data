package cn.spring_data.project.entity;

import jakarta.persistence.*;
import lombok.Data;

//import static jdk.jfr.internal.SecuritySupport.registerEvent;

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

//    public void afterSave() {
//        //registers the CustomerCreationEvent using the AbstractAggregateRoot's registerEvent method
//        registerEvent(new CustomerCreationEvent());
//    }
}
