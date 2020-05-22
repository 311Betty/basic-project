package com.betty.lesson.controller;

import com.betty.lesson.vo.req.SwaggerReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName SwaggerController.java
 * @Description TODO
 * @createTime 2020年05月22日 13:10:00
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试swagger模块")
public class SwaggerController {
    @ApiOperation(value = "第一个swagger接口")
    @PostMapping("/swagger")
    public SwaggerReqVO testSwagger(@RequestBody SwaggerReqVO vo, HttpServletRequest request) {
        System.out.println(request.getHeader("token"));
        return vo;
    }
}
