package com.kk.springboot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kk.springboot.demo.entity.Department;
import com.kk.springboot.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping ("/department")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		log.info("Department save request");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/department")
	public List<Department> fetchDepartments(){
		log.info("Department fetch all request");
		return departmentService.fetchDepartmens();
	}
	
	@GetMapping("/department/{id}")
	public Department fetchDepartmentById(@PathVariable ("id") Long id) {
		log.info("Department fetch by id request");
		return departmentService.fetchDepartmenById(id);
	}
	
	@DeleteMapping("/department/{id}")
	public String deleteDepartmentById(@PathVariable ("id") Long id) {
		log.info("Department delete by id request");
		departmentService.deleteDepartmenById(id);
		return id + " deleted successfully";
	}
	
	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable ("id") Long id, 
										@Valid @RequestBody Department department) {
		log.info("Department update request");
		return departmentService.updateDepartment(id, department);
	}
	
	@GetMapping("/department/name/{name}")
	public Department fetchDepartmentByName(@PathVariable ("name") String name) {
		log.info("Department fetch by name request");
		return departmentService.fetchDepartmenByName(name);
	}
}
