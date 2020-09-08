package com.alex.seckill.vo;

import com.alex.seckill.validator.IsPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author wsh
 * @date 2020-09-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    @NotNull
    @IsPhone
    private String phone;
    @NotNull
    private String password;
}
