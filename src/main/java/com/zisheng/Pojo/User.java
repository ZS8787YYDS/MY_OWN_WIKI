package com.zisheng.Pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer gender;
    private Integer age;
//    private LocalDateTime createTime;
//    private LocalDateTime UpdateTime;
}
