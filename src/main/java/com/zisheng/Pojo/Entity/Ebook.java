package com.zisheng.Pojo.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "电子书实体类")
public class Ebook implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "分类1Id")
    private Long category1Id;
    @ApiModelProperty(value = "分类2Id")
    private Long category2Id;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "封面")
    private String cover;
    @ApiModelProperty(value = "文档数目")
    private Integer docCount;
    @ApiModelProperty(value = "阅读数目")
    private Integer viewCount;
    @ApiModelProperty(value = "点赞数目")
    private Integer voteCount;
}
