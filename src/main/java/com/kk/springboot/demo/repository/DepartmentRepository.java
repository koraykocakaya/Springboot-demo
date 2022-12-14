package com.kk.springboot.demo.repository;

import com.kk.springboot.demo.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findDepartmentByName(String name);
}
