package com.angular.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.demo.dao.UserRepository;
import com.angular.demo.model.User;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class RegisterServiceApplication
{
	
	@Autowired
	private  UserRepository userRepository;
	
	@PostMapping(value="/save")
	public String saveRegister(@RequestBody User user)
	{
		userRepository.save(user);
		return " Hii  "+user.getName()+"  your registration completed  :) ";
	}
	
	@GetMapping(value="/all")
	public List<User> AllUsers()
	{
		return userRepository.findAll();
	}
	
	@GetMapping(value="/findUser/{email}")
	public List<User> findUser(@PathVariable String email)
	{
		return userRepository.findByEmail(email);
	}
	
	@DeleteMapping(value="/cancel/{id}")
	public List<User> cancelRegistration(@PathVariable int id)
	{
		 userRepository.deleteById(id);
		return userRepository.findAll();
	}
	
	
	public static void main(String[] args)
	{
		
		ApplicationContext cxt = SpringApplication.run(RegisterServiceApplication.class, args);
		UserRepository repo = (UserRepository) cxt.getBean(UserRepository.class);
	
	    repo.save(new User("ram","ram@gmail.com",3,"Telecom"));
	    repo.save(new User("abc","abc@gmail.com",2,"ecom"));
	    repo.save(new User("mona","mona@gmail.com",3,"Telecom"));
	    repo.save(new User("shyam","shyam@gmail.com",5,"Finance"));
	    
	    
	    List<User> users = repo.findAll();
	    users.forEach(m -> System.out.println(m.getName()));
		
	}

}
