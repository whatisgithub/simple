package cn.cpic.insurance.web.exception;

import cn.cpic.insurance.web.controller.vo.UserVo;
import cn.cpic.insurance.web.exception.entity.ErrorRespEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ControllerAdvice 捕获 Controller 层抛出的异常，如果添加 @ResponseBody 返回信息则为JSON 格式。
 * @RestControllerAdvice 相当于 @ControllerAdvice 与 @ResponseBody 的结合体。
 * @ExceptionHandler 统一处理一种类的异常，减少代码重复率，降低复杂度。
 * 创建一个 GlobalExceptionHandler 类，并添加上 @RestControllerAdvice 注解就可以定义出异常通知类了，然后在定义的方法中添加上 @ExceptionHandler 即可实现异常的捕捉…
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public Object customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        //TODO 业务异常处理自定义
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        logger.error(e);
        return new ErrorRespEntity("0000", "出错了");
    }

    /**
     * 没有定义的异常处理方法
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("捕获到全局异常", ex);
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(new ErrorRespEntity(status.value()+"", exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()), status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
                    + ",信息：" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorRespEntity(status.value()+"", "参数转换失败"), status);
        }
        return new ResponseEntity<>(new ErrorRespEntity(status.value()+"", "参数转换失败"), status);
    }
}
