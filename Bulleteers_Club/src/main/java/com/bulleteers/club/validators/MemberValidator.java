package com.bulleteers.club.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bulleteers.club.pojo.Member;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class aClass) {
		return aClass.equals(Member.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
	
		Member member = (Member) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","error.invalid.member","First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","error.invalid.member","First Name Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","error.invalid.member","First Name Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","error.invalid.member","First Name Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","error.invalid.member","First Name Required");
		
	}
	
	
	

}
