package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.bean.Student;
/**
 * @author vinod.nagulkar
 *
 */
@Configuration
public class BeanConfig 
{
	@Bean
	@Scope("prototype")
	public Student getStudent() 
	{
		return new Student();
	}
}
