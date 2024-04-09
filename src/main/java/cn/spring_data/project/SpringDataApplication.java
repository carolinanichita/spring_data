package cn.spring_data.project;

import cn.spring_data.project.entity.Customer;
import cn.spring_data.project.entity.events.CustomerCreationEvent;

import cn.spring_data.project.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringDataApplication.class);

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args).close();
	}

	// listener method to handle the CustomerCreationEvent using the After Commit transaction phase
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void handleCustomerCreationEvent(CustomerCreationEvent event) {
		log.info("Handled CustomerCreationEvent...");
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		Customer customer1 = new Customer();
		customer1.setFirstName("Carolina");
		customer1.setLastName("Nichita");
		customer1.afterSave();
		customerRepository.save(customer1);
	}

}