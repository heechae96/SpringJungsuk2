package com.fastcampus.ch2_intelliJ;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
			return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
//        return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
    }

    @Override
    public void validate(Object target, Errors errors) {
        //                  검증 할 객체, 검증시 발생한 에러 저장소
        System.out.println("UserValidator.validate() is called");

        User user = (User)target;

        String id = user.getId();

        //		if(id==null || "".equals(id.trim())) {
        //			errors.rejectValue("id", "required");
        //		}

        // nulll이거나 빈 문자열인 경우
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");

        if(id==null || id.length() <  5 || id.length() > 12) {
            errors.rejectValue("id", "invalidLength");
        }
    }
}