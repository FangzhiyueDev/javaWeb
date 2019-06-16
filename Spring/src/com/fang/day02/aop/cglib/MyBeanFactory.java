package com.fang.day02.aop.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {

	public static UserService createServic() {

		UserService userService = new UserServiceImpl();

		MyAspect myAspect = new MyAspect();

		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(userService.getClass());

		enhancer.setCallback(new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				myAspect.before();

				// 执行目标类的方法
				Object obj = method.invoke(userService, args);
				// * 执行代理类的父类 ，执行目标类 （目标类和代理类 父子关系）
				methodProxy.invokeSuper(proxy, args);
				myAspect.after();
				return obj;
			}
		});
		// 3.4 创建代理
		UserServiceImpl proxService = (UserServiceImpl) enhancer.create();

		return proxService;
	}

}
