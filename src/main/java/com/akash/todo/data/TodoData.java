package com.akash.todo.data;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties(value =  "hibernateLazyinitializer")
@DynamicUpdate // for updating specific field of saved data
public class TodoData {
	@Id
	@GeneratedValue
	int id;
	
	@Size(min=5, message="Should be atleast 5 character string!!")
	String description;
	
	@FutureOrPresent
	@JsonFormat(pattern="yyyy-MM-dd")
	LocalDate targetDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	
	public TodoData() {
		super();
	}
	
	public TodoData(int id, String description, LocalDate targetDate) {
		super();
		this.id = id;
		this.description = description;
		this.targetDate = targetDate;
	}
	@Override
	public String toString() {
		return "TodoData [id=" + id + ", description=" + description + ", targetDate=" + targetDate + "]";
	}
	
	
}
