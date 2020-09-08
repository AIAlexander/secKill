package com.alex.seckill.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wsh
 * @date 2020-09-08
 */
@Slf4j
public class ValidatorUtil {

    private static final Pattern PHONE_PATTERN = Pattern.compile("1\\d{10}");

    public static boolean isPhone(String src){
        log.info("Phone: {}",src);
        if(StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m = PHONE_PATTERN.matcher(src);
        return m.matches();
    }
}
