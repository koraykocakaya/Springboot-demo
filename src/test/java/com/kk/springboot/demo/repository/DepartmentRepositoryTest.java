package com.kk.springboot.demo.repository;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kk.springboot.demo.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department =
                Department.builder()
                .name("Comp eng")
                .code("CENG")
                .address("Ankara")
                .email("koraykocak@gmail.com")
              //  .departmentId(1L)
                .build();
		entityManager.persist(department);
	}

	@Test
	void should_fetchRecord_whenFetchWithAppropriateId() {
		// given
		String name = "Comp eng";
		String code = "CENG";
		Long id = 1L;

		// when
		Department department = departmentRepository.findById(id).get();
		
		// then
		assertAll(
			() -> assertEquals(department.getCode(), code),
			() -> assertEquals(department.getName(), name),
			() -> assertEquals(department.getId(), id)
		);
	} 
	
	@Test
	void should_returnNull_whenFetchWithNotAppropriateId() {
		// given
		Long id = 10000L;
		
		// when
		Optional<Department> depOpt = departmentRepository.findById(id);
		
		// then
		assertFalse(depOpt.isPresent());
	} 

}
