package com.betty.lesson.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName SwaggerReqVO.java
 * @Description TODO
 * @createTime 2020年05月22日 13:08:00
 */
@Data
public class SwaggerReqVO {
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "年龄")
    private Integer age;
}
