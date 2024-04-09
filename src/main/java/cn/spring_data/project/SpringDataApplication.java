package cn.spring_data.project;

import cn.spring_data.project.repository.CustomCustomerRepository;
import cn.spring_data.project.repository.CustomCustomerRepositoryImpl;

import cn.spring_data.project.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		//projection using interface
		log.info(customerRepository.findFirstByOrderByLastNameAsc().getFirstName());

		//projection using class
//		log.info(customerRepository.findFirstByOrderByFirstNameDesc().getFullName());
	}
}