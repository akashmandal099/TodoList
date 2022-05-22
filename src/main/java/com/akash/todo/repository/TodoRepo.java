package com.akash.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akash.todo.data.TodoData;

@Repository
public interface TodoRepo extends JpaRepository<TodoData, Integer> {
	TodoData findById(int id);
}
