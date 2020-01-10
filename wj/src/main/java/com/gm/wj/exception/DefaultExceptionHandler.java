package com.gm.wj.exception;

import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Evan
 * @date 2019/11
 */

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Result handleAuthorizationException(UnauthorizedException e) {
        String message = "权限认证失败";
        return ResultFactory.buildFailResult(message);
    }
}
