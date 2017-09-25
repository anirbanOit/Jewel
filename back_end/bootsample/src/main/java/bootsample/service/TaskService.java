package bootsample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootsample.dao.TaskRepository;
import bootsample.model.Task;


@Service

public class TaskService {
	
	private final TaskRepository taskrepository;

	public TaskService(TaskRepository taskrepository) {
		this.taskrepository = taskrepository;
	}
	
	public List<Task> findAll()
	{
		List<Task> tasks= new ArrayList<>();
		tasks = (List<Task>) taskrepository.findAll();
		for(Task task : taskrepository.findAll())
		{
			tasks.add(task);
		}
		
		return tasks;
	}
	
	public void save(Task task)
	{
		taskrepository.save(task);
	}
	
	public void delete(int id)
	{
		taskrepository.delete(id);
	}

}
