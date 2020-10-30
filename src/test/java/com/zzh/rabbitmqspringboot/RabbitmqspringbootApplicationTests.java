package com.zzh.rabbitmqspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqspringbootApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("hello","hello world");
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello work!");
        }
    }

//    work模型使用

    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello work!");
        }
    }


//    Fanout 广播模型

    @Test
    public void testFanout() throws InterruptedException {
        rabbitTemplate.convertAndSend("logs","","这是日志广播");
    }

//Route 路由模型

    @Test
    public void testDirect(){
        rabbitTemplate.convertAndSend("directs","error","error 的日志信息");
    }


    //topic

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save.findAll","user.save.findAll 的消息");
    }
}
