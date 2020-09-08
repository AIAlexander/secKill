package com.alex.seckill.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author wsh
 * @date 2020-09-08
 */
@Documented
@Constraint(
        validatedBy = {MobilePatternValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsPhone {

    boolean required() default false;

    String message() default "手机格式错误！";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
