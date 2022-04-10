package com.example.cabbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.cabbooking.testdriver.TestDriver;

@SpringBootApplication
public class CabbookingApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=SpringApplication.run(CabbookingApplication.class, args);
		
		// driver class for executing the testcases
		TestDriver theCaboperator = applicationContext.getBean(TestDriver.class);
		theCaboperator.runCabOpeartor();
		
		
	}

}
