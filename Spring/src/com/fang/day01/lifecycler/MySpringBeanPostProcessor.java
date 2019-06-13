package com.fang.day01.lifecycler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MySpringBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("后执行方法" + beanName);

		// 使用代理

		return Proxy.newProxyInstance(MySpringBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("------开启事务");

						// 执行目标方法
						Object obj = method.invoke(bean, args);
						System.out.println("------提交事务");
						return obj;
					}
				});
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("前执行方法" + beanName);
		return bean;
	}

}
