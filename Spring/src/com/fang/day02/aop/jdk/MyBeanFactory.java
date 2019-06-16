package com.fang.day02.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

	public static UserService createServic() {

		UserService userService = new UserServiceImpl();

		MyAspect myAspect = new MyAspect();

		UserService proxService = (UserService) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(),
				userService.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						myAspect.before();
						Object obj = method.invoke(userService, args);
						myAspect.after();
						return obj;
					}
				});
		return proxService;
	}

}
