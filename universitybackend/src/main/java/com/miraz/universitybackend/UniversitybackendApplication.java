package com.miraz.universitybackend;

import com.miraz.universitybackend.services.ChangeStreamListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class UniversitybackendApplication {
	@Autowired
	private ChangeStreamListener changeStreamListener;

	public static void main(String[] args) {
		SpringApplication.run(UniversitybackendApplication.class, args);
	}

	@PostConstruct
	public void startChangeStreamListener() {
		changeStreamListener.startChangeStream();
	}
}
