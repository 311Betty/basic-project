package com.betty.lesson.controller;

import com.betty.lesson.vo.resp.ResponseVO;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName LombokController.java
 * @Description TODO
 * @createTime 2020年05月22日 09:32:00
 */
@RestController
@RequestMapping("/test")
public class LombokController {
    @GetMapping("/lombok")
    public ResponseVO testLombok() {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setName("betty");
        responseVO.setAge("123");
        responseVO.setPhone("12345679");
        return responseVO;
    }
}
