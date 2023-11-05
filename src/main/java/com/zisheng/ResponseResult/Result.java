package com.zisheng.ResponseResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 该方法为统一的响应结果类
 * @param <T>
 */
@Data
@ApiModel(description = "返回结果类")
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "响应状态")
    private Boolean success = true;
    @ApiModelProperty(value = "错误信息")
    private String message;
    @ApiModelProperty(value = "响应内容")
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
