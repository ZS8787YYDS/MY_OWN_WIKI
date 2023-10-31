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
    private Boolean success = true;
    private String message;
    private T content;
    public static <T> Result<T> success()
    {
        return new Result<>();
    }
    public static <T> Result<T> success(T content)
    {
        Result<T> result = new Result<>();
        result.content = content;
        return result;
    }
    public static <T> Result<T> error(String message)
    {
        return new Result<>(false,message,null);
    }
}
