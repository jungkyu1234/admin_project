package com.human.admin;

import com.human.admin.dto.EmployeeDto;
import com.human.admin.mapper.EmployeeMapper;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdminApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@DisplayName(value = "전체조회 테스트")
	@Test
	void findAllTest() {
		List<EmployeeDto> employeeDtoList = employeeMapper.findAll(1);
		Assertions.assertThat(employeeDtoList.size()).isEqualTo(5);
	}

}
