package com.gkfcsolution.springboot_commons_taks_ch2.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordRuleValidator.class)
public @interface Password {
    String message() default "Le mot de passe ne respecte pas les règles de sécurité";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
