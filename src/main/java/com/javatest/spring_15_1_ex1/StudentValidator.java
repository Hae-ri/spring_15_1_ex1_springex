package com.javatest.spring_15_1_ex1;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { // 검증할 객체의 클래스 타입 정보
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student student = (Student) target;
		
		String studentId = student.getId();
		int studentPw = student.getPw();
		
		if(studentId == null || studentId.trim().isEmpty()) {
			System.out.println("student의 id 값이 null입니다.");
			errors.reject("id", "trouble");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "trouble");
		
	}

}
