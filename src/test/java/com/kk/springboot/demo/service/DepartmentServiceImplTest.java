package com.kk.springboot.demo.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.kk.springboot.demo.error.DepartmentNotFoundException;
import com.kk.springboot.demo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceImplTest {

	@Autowired
	DepartmentService departmentService;
	
	@MockBean
	DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		// given
		Mockito.when(departmentRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		
		
		// when
		Executable executable = () -> departmentService.fetchDepartmenById(1L);
		
		// then
		assertThrows(DepartmentNotFoundException.class, executable);
	}

}
