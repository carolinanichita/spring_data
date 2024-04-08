package cn.spring_data.project;

import cn.spring_data.project.entity.Customer;
import cn.spring_data.project.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(SpringDataApplication.class);
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args).close();
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		// dynamic query methods
		log.info(String.valueOf(customerRepository.findAllByFirstName("Nichita")));
		log.info(String.valueOf(customerRepository.findFirstByLastNameOrderByFirstNameDesc("Carolina")));
		log.info(String.valueOf(customerRepository.findFirstByOrderByFirstNameAsc()));
		log.info(String.valueOf(customerRepository
				.readAllByOrderByIdDesc()
				.map(i -> i.getLastName() + i.getFirstName())
				.collect(Collectors.toList())));

		// @Query
		log.info(String.valueOf(customerRepository.fetchFirstCustomerUsingQuery()));

		// @NamedQuery
		log.info(String.valueOf(customerRepository.searchUsingNamedQuery("Nichita")));

		log.info(String.valueOf(entityManager
				.createNamedQuery("Customer.searchUsingNamedQuery")
				.setParameter(1, "Sofia")
				.getResultList()));

//		//Create
//		Customer customer = new Customer();
//		customer.setFirstName("Carolina");
//		customer.setLastName("Nichita");
//		customerRepository.save(customer);
//
//		//Read
//		Customer c = customerRepository.findById(customer.getId()).get();
//		log.info(String.valueOf(c));
//
//		//Update
//		c.setLastName("Sofia Genica");
//		customerRepository.save(c);
//		log.info(String.valueOf(c));
//
//		//find all
//		log.info(String.valueOf(customerRepository.findAll()));
//
//		//Delete
//		customerRepository.delete(c);
//	}
	}
}
