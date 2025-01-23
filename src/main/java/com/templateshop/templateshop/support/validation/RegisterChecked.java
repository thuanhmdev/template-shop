package com.templateshop.templateshop.support.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = RegisterValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegisterChecked {
    String message() default "Đăng ký thất bại vui lòng kiểm tra tra lại các trường";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
