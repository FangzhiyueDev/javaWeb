package com.fang.day01.lifecycler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

public class UserServiceImpl implements UserService {

	/*
	 * 
	 * 
	 * Bean的建立， 由BeanFactory读取Bean定义文件，并生成各个实例 Setter注入，执行Bean的属性依赖注入
	 * BeanNameAware的setBeanName(), 如果实现该接口，则执行其setBeanName方法
	 * BeanFactoryAware的setBeanFactory()，如果实现该接口，则执行其setBeanFactory方法
	 * BeanPostProcessor的processBeforeInitialization()，如果有关联的processor，
	 * 则在Bean初始化之前都会执行这个实例的processBeforeInitialization()方法
	 * InitializingBean的afterPropertiesSet()，如果实现了该接口，则执行其afterPropertiesSet()方法
	 * Bean定义文件中定义init-method
	 * BeanPostProcessors的processAfterInitialization()，如果有关联的processor，
	 * 则在Bean初始化之前都会执行这个实例的processAfterInitialization()方法
	 * DisposableBean的destroy()，在容器关闭时，如果Bean类实现了该接口，则执行它的destroy()方法
	 * Bean定义文件中定义destroy-method，在容器关闭时，可以在Bean定义文件中使用“destory-method”定义的方法
	 * 
	 * 
	 * 
	 */

	/**
	 * Bean定义文件中定义init-method
	 */
	public void init() {
		System.out.println("初始化");
	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("add User");
	}

	/**
	 * Bean定义文件中定义destroy-method，在容器关闭时，可以在Bean定义文件中使用“destory-method”定义的方法
	 */
	public void destory() {
		System.out.println("销毁");
	}

	/**
	 * BeanNameAware的setBeanName(),
	 * 
	 */
	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * BeanFactoryAware的setBeanFactory()，如果实现该接口，则执行其setBeanFactory方法
	 */
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub

	}

	/**
	 * InitializingBean的afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub

	}

	/**
	 * DisposableBean的destroy()，在容器关闭时，如果Bean类实现了该接口，则执行它的destroy()方法
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

}
