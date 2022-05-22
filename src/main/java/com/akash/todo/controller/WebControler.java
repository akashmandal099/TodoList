package com.akash.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.todo.data.TodoData;
import com.akash.todo.repository.TodoRepo;



@RestController
public class WebControler {

	
	@Autowired
	TodoRepo repo;
	
	@GetMapping("/tasks")
	public List<TodoData> getTasks() {
		return repo.findAll();
	}
	
	@PostMapping("/tasks")
	public TodoData postTodo(@RequestBody TodoData data) {
		repo.save(data);
		return data;
	}
	
	@DeleteMapping("/tasks/{id}")
	public TodoData delTodo(@PathVariable int id)
	{
		TodoData deleted = repo.getById(id);
		System.out.println(deleted);
		repo.delete(deleted);
		return deleted;
	}
	
	@PutMapping("/tasks/{id}")
	public TodoData updateToDo(@PathVariable int id, @RequestBody TodoData data) {
		TodoData prevData = repo.findById(id);
		if(data.getDescription() != null) {
			prevData.setDescription(data.getDescription());
		}
		if(data.getTargetDate() != null) {
			prevData.setTargetDate(data.getTargetDate());
		}
		System.out.println(data.toString());
		repo.save(prevData);
		return prevData;
	}

}
