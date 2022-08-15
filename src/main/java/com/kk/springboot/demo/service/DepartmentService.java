package com.kk.springboot.demo.service;

import java.util.List;

import com.kk.springboot.demo.entity.Department;
import com.kk.springboot.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	
	public List<Department> fetchDepartmens();
	
	public Department fetchDepartmenById(Long id) throws DepartmentNotFoundException;
	
	public void deleteDepartmenById(Long id);
	
	public Department updateDepartment(Long id, Department department);
	
	public Department fetchDepartmenByName(String name);
}
