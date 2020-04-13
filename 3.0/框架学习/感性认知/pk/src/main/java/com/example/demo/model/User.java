package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年04月01日 11:05:00
 */
@Data
@TableName(value = "name")
public class User implements Serializable {
    private String name;
    private Integer age;
    private  Integer id;


}
