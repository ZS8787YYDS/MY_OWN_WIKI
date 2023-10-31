package com.zisheng.Pojo.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "分类1Id")
    private Long category1Id;
    @ApiModelProperty(value = "分类2Id")
    private Long category2Id;
}
