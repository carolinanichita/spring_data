package cn.spring_data.project;

import cn.spring_data.project.repository.CustomCustomerRepository;
import cn.spring_data.project.repository.CustomCustomerRepositoryImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args).close();
	}

	//manual wiring
	@Bean
	CustomCustomerRepository getCustomCustomerRepository() {
		return new CustomCustomerRepositoryImpl();
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info(String.valueOf(getCustomCustomerRepository().findCustomerCustom("Thomas", "Edison")));
	}
}