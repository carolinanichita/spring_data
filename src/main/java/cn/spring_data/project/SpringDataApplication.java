package cn.spring_data.project;

import cn.spring_data.project.entity.QCustomer;

import cn.spring_data.project.repository.CustomerRepository;

import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringDataApplication.class);

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args).close();
	}

	@Override
	public void run(String... strings) throws Exception {
		//query dsl predicate
		QCustomer customer = QCustomer.customer;
		Predicate predicate = customer.firstName.equalsIgnoreCase("thomas")
				.and(customer.lastName.startsWithIgnoreCase("edi"));

		log.info(String.valueOf(customerRepository.findAll(predicate)));
	}
}