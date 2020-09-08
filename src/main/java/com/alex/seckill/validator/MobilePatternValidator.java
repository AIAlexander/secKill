package com.alex.seckill.validator;

import com.alex.seckill.util.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author wsh
 * @date 2020-09-08
 */

public class MobilePatternValidator implements ConstraintValidator<IsPhone, String> {

    private boolean required = true;

    @Override
    public void initialize(IsPhone isPhone) {
        this.required = isPhone.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorUtil.isPhone(s);
        }else{
            if(StringUtils.isEmpty(s)){
                return true;
            }else{
                return ValidatorUtil.isPhone(s);
            }
        }
    }
}
