package com.allanAsc.MyGrowthApiChallengeV2;

import com.allanAsc.MyGrowthApiChallengeV2.user.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyGrowthApiChallengeV2Application implements CommandLineRunner {

	@Autowired
	MyUserDetailsService userDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(MyGrowthApiChallengeV2Application.class, args);
	}

	@Override
	public void run(String[] args){
		// Call the service method to create table and insert data
		userDetailsService.createTable();
	}

}
