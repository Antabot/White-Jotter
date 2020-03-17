package com.gm.wj.result;

import lombok.Data;

/**
 * @author Evan
 * @date 2019/4
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
