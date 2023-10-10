package com.nagarro.configuration;

//Bean Configuration class
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.nagarro.service.BookService;
import com.nagarro.service.UserService;
import com.nagarro.service.impl.BookServiceImp;
import com.nagarro.service.impl.UserServiceImp;


@Configuration
@EnableScheduling
public class AppConfig {	
	@Bean
	public UserService getUserService() {
		return new UserServiceImp();
	}
	
	@Bean
	public BookService getBookService() {
		return new BookServiceImp();
	}

}
