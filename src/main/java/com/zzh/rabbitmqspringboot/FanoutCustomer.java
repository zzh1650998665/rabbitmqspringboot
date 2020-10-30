package com.zzh.rabbitmqspringboot;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutCustomer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name="logs",type = "fanout")
    ))
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue, //创建临时队列
            exchange = @Exchange(name="logs",type = "fanout")  //绑定交换机类型
    ))
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }
}