package cn.cpic.insurance.web.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * web 常用工具类
 */
public class WebUtil {
    public static String handlerErrmsg(BindingResult br) {
        List<String> errorMsg = new ArrayList<>();
        List<FieldError> fieldErrors = br.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errorMsg.add(fieldError.getField()+": "+fieldError.getDefaultMessage()+";");
        }
        return errorMsg.toString();
    }
}
