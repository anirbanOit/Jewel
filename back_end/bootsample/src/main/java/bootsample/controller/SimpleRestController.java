package bootsample.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootsample.model.Task;
import bootsample.service.TaskService;

@RestController
public class SimpleRestController {
	
	@Autowired
	private TaskService taskservice;
	
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello_world";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks()
	{
		return taskservice.findAll().toString();
	}
	
	@GetMapping("/save-tasks")
	public String saveTasks(@RequestParam String name,@RequestParam String desc)
	{
		Task task = new Task(name,desc,new Date(),false);
		taskservice.save(task);
		return "Task Saved!!" ;
	}
	
	@GetMapping("/delete-tasks")
	public String deleteTasks(@RequestParam int id)
	{
		taskservice.delete(id);
		return "Task deleted!!" ;
	}


}
