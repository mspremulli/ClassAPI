package com.example.ClassAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/*
CRUD
Create: Post
Read: Get
Update: Put
Delete: Delete
 */

//@PostMapping
//@GetMapping
//@PutMapping
//@DeleteMapping

@SpringBootApplication
@RestController
public class ClassApiApplication {
	private HashMap<Integer, String> dataBase = new HashMap<>();
	private int indexCounter = 0;

	public static void main(String[] args) {
		SpringApplication.run(ClassApiApplication.class, args);
	}

	@PostMapping("/")
	public String postData(@RequestHeader(value = "header", defaultValue = "") String header, @RequestBody String body){
		dataBase.put(indexCounter++, body);
		System.out.println(dataBase);
		return body;
	}

	@GetMapping("{index}")
	public String getData(@PathVariable("index") int index) {
		return dataBase.get(index);
	}

	@DeleteMapping("{index}")
	String deleteData(@PathVariable("index")int index){
		return dataBase.remove(index);
	}

	@PutMapping("{index}")
	String deleteData(@PathVariable("index") int index, @RequestBody String newData){
		dataBase.put(index, newData);
		System.out.println(dataBase);
		return newData;
	}

}
