package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyUSer;

public class TestMyUser {
public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	MyUSer u1=(MyUSer)ctx.getBean(MyUSer.class);
	System.out.println(u1);
	System.out.println("before close");
	((ClassPathXmlApplicationContext)ctx).close();
}
}
