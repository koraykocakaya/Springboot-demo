package com.kk.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import com.kk.springboot.demo.entity.Department;
import com.kk.springboot.demo.error.DepartmentNotFoundException;
import com.kk.springboot.demo.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	@Override
	public List<Department> fetchDepartmens(){
		return departmentRepository.findAll();
	}
	
	@Override
	public Department fetchDepartmenById(Long id) throws DepartmentNotFoundException {
		Optional<Department> deptOpt = departmentRepository.findById(id);
		if(!deptOpt.isPresent())
			throw new DepartmentNotFoundException("Department not found");
		return deptOpt.get();
	}
	
	@Override
	public void deleteDepartmenById(Long id) {
		departmentRepository.deleteById(id);
	} 
	
	@Override
	public Department updateDepartment(Long id, Department department) {
		Department departmentDB = departmentRepository.findById(id).get();
		
		departmentDB.setAddress(department.getAddress());
		departmentDB.setCode(department.getCode());
		departmentDB.setName(department.getName());
		departmentRepository.save(departmentDB);
		
		return departmentDB;
	}
	
	@Override
	public Department fetchDepartmenByName(String name) {
		return departmentRepository.findDepartmentByName(name);
	}
}
