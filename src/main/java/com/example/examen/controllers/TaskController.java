package com.example.examen.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.examen.models.Task;
import com.example.examen.models.User;
import com.example.examen.service.TaskService;
import com.example.examen.service.UserService;

@Controller
public class TaskController {

	private final TaskService taskService;
	private final UserService userService;
	
	public TaskController(TaskService taskService, UserService userService) {
		this.taskService = taskService;
		this.userService = userService;
	}
	
	@RequestMapping("/tasks")
	public String index(HttpSession session, Model model) {
		List<Task> tasks = taskService.allTask();
		model.addAttribute("tasks", tasks);
		
		Long userId = (Long) session.getAttribute("userId");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user", u);
		return "/task/index.jsp";
	}
	
	@RequestMapping("/tasks/new")
	public String newTask(@ModelAttribute("task") Task task, Model model) {
		model.addAttribute("task", task);
		return "/task/new.jsp";
	}
	
	@RequestMapping(value="tasks", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "/task/new.jsp";
		}else {
			Long userId = (Long) session.getAttribute("userId");
	    	User u = userService.findUserById(userId);
	    	task.setUser(u);
			taskService.createTask(task);
			return "redirect:/tasks";
		}
	}
	
	@GetMapping(value="/tasks/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Task task = taskService.findTask(id);
		model.addAttribute("task", task);
		return "/task/show.jsp";
	}
	
	@RequestMapping("/tasks/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Task task = taskService.findTask(id);
		model.addAttribute("task", task);
		return "/task/edit.jsp";
	}
	
	@RequestMapping(value="/tasks/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "/task/edit.jsp";
		}else {
			Long userId = (Long) session.getAttribute("userId");
	    	User u = userService.findUserById(userId);
	    	task.setUser(u);
			taskService.updateTask(task);
			return "redirect:/tasks";
		}
	}
	
	@RequestMapping(value="/tasks/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		taskService.deleteTask(id);
		return "redirect:/tasks";
	}
	
}
