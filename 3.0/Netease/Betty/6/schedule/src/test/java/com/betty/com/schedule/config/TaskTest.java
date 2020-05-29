package com.betty.com.schedule.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

@SpringBootTest
class TaskTest {
    @Autowired
    Task task;

    @Test
    public void testTask() throws Exception {
        task.taskOne();
        task.taskTwo();
        task.taskThree();
    }

    @Test
    public void testAsync() throws Exception {
        //计算三个任务总耗时
        long start=System.currentTimeMillis();

        //执行任务123
        Future<String> one = task.taskOne();
        Future<String> two = task.taskTwo();
        Future<String> three = task.taskThree();
        //while true 三个任务完成 退出
        while (true) {
            if (one.isDone() && two.isDone() && three.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        //否则等待1000
        long end =System.currentTimeMillis();
        System.out.println("任务全部完成，耗时"+(end -start)+"毫秒");
    }

}
