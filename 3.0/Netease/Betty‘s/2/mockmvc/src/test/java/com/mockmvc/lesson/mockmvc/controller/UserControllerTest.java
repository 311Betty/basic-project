package com.mockmvc.lesson.mockmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mockmvc.lesson.mockmvc.entity.UserInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void getUserInfo() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


        //mock方法
        MvcResult result = mockMvc.perform(
                //1.perform

                //get
                MockMvcRequestBuilders.get("/user")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        //contenttype  accept  param param adddo  expect  return sout

                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .param("name", "betty")
                        .param("age", "11"))
                .andDo(print())
                //验证状态  name  age
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("betty"))
                .andExpect(jsonPath("$.age").value("11"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void getUserInfo1() throws Exception {
        //1.
        //1.
        //2.
        //1.写入属性
        //1.Userinfo赋值···
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        UserInfo userInfo = new UserInfo();
        userInfo.setAge("111");
        userInfo.setName("bbb");
        //将userinfo对象编写成json格式的string
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
        String json = objectWriter.writeValueAsString(userInfo);
        //2.perform
        MvcResult result = mockMvc.perform(
                //get
                MockMvcRequestBuilders.post("/user")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        //content
                        //contenttype
//accept
                        .accept(MediaType.APPLICATION_JSON_UTF8)

        )
                .andDo(print())
                .andExpect(jsonPath("$.name").value("bbb"))
                .andExpect(jsonPath("$.age").value("111"))

                .andReturn();


        //do
        //expect
        //return
        System.out.println(result.getResponse().getContentAsString());


    }
}
