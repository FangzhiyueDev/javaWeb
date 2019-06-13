package com.fang.day01.lifecycler;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;

public interface UserService
		extends BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationContextAware, DisposableBean {

	public void addUser();

}
