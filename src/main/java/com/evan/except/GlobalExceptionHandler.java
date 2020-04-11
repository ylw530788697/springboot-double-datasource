package com.evan.except;

import com.evan.Response;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author evanYang
 * @version 1.0
 * @date 04/11/2020 10:50
 */
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response<?> handleException(Exception e) {
        return Response.error( e.getMessage());
    }

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Response<?> handleBusinessException(BusinessException e) {
        return Response.error( e.getMessage());
    }

    /**
     * 拦截参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        StringBuilder errorMessage=new StringBuilder();
        List<ObjectError> objectErrors=methodArgumentNotValidException.getBindingResult().getAllErrors();
        if (!CollectionUtils.isEmpty(objectErrors)) {
            for (int i = 0; i < objectErrors.size(); i++) {
                if (i == 0) {
                    errorMessage.append(objectErrors.get(i).getDefaultMessage());
                } else {
                    errorMessage.append(",");
                    errorMessage.append(objectErrors.get(i).getDefaultMessage());
                }
            }
        }else {
            errorMessage.append("MethodArgumentNotValidException occured.");
        }
        return Response.error("400", errorMessage.toString(),null);
    }

    /**
     * 拦截自定义约束异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Response<?> handle(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        String errorMessage = "";
        if (!violations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            violations.forEach(violation -> builder.append(" " + violation.getMessage()));
            errorMessage = builder.toString();
        } else {
            errorMessage = "ConstraintViolationException occured.";
        }
        return Response.error("400", errorMessage,null);
    }



}
