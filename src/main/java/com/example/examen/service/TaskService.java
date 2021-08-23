package com.example.examen.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.examen.models.Task;
import com.example.examen.models.User;
import com.example.examen.repositories.TaskRepository;
import com.example.examen.repositories.UserRepository;

@Service
public class TaskService {

private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	// Devolviendo todas las tareas
		public List<Task> allTask() {
			return taskRepository.findAll();
		}
		
		// Creando tarea.
		public Task createTask(Task t) {
			return taskRepository.save(t);
		}
		
		// Obteniendo la información de una tarea
		public Task findTask(Long id) {
			Optional<Task> optionalTask = taskRepository.findById(id);
			if (optionalTask.isPresent()) {
				return optionalTask.get();
			} else {
				return null;
			}

		}
		
		//actualizar tarea
		public Task updateTask(Task task) {
			return taskRepository.save(task);
		}
		
		//eliminar tarea
		public void deleteTask(Long id) {
			taskRepository.deleteById(id);;
		}
	
}
