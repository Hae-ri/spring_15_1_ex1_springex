package com.javatest.spring_15_1_ex1;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { // ������ ��ü�� Ŭ���� Ÿ�� ����
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
			System.out.println("student�� id ���� null�Դϴ�.");
			errors.reject("id", "trouble");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "trouble");
		
	}

}
