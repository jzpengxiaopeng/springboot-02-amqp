package com.atguigu.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.atguigu.amqp.bean.Book;

@Service
public class BookService {

	@RabbitListener(queues = {"atguigu", "atguigu.news"})
	public void receive(Book book) {
		System.out.println("收到的消息是：" + book);
	}
	
	@RabbitListener(queues = {"atguigu.emps", "gulixueyuan.news"})
	public void receive2(Message message) {
		System.out.println(message.getBody());
		System.out.println(message.getMessageProperties());
	}
}
