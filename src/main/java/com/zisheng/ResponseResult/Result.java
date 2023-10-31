package com.zisheng.ResponseResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 该方法为统一的响应结果
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    public static <T> Result<T> success()
    {
        Result<T> result = new Result<>();
        result.code = 1;
        return result;
    }
    public static <T> Result<T> success(T data)
    {
        Result<T> result = new Result<>();
        result.code = 1;
        result.data = data;
        return result;
    }
    public static <T> Result<T> error(String msg)
    {
        return new Result<>(0,msg,null);
    }
}
