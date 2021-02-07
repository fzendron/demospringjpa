package com.zendron.demo;

import com.zendron.demo.model.People;
import com.zendron.demo.repository.PeopleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.LongStream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	CommandLineRunner init(PeopleRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1,11)
					.mapToObj(i -> {
						People people = new People();
						people.setName("Name" + i);
						people.setEmail("Email" + i);
						people.setPhone("Phone" + i);
						return people;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}

}
