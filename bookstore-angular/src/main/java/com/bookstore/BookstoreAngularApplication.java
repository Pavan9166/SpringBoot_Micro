package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.domain.Security.Role;
import com.bookstore.domain.Security.UserRole;
import com.bookstore.domain.model.User;
import com.bookstore.security.config.SecurityUtility;
import com.bookstore.security.service.UserService;

@SpringBootApplication
public class BookstoreAngularApplication  implements CommandLineRunner{
    @Autowired 
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreAngularApplication.class, args);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/token").allowedOrigins("http://localhost:4200");
//			}
//		};
//	}

	

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User();
		user1.setFirstName("pavan");
		user1.setLastName("kumar");
		user1.setEmail("pavan@gmail.com");
		user1.setPhone("9999999999");
		user1.setUsername("p");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("q"));
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		//role1.setRoleId(1);
		role1.setRoleName("User_Role");
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);
		userRoles.clear();

		User user2 = new User();
		user2.setFirstName("Kalyan");
		user2.setLastName("Kanna");
		user2.setEmail("kanna@gmail.com");
		user2.setPhone("9999999999");
		user2.setUsername("g");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("h"));
		Role role2 = new Role();
		//role2.setRoleId(0);
		role2.setRoleName("Admin");
		userRoles.add(new UserRole(user2, role2));
		userService.createUser(user2, userRoles);
		

	}

}
