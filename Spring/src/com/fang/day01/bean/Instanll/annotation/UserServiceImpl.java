package com.fang.day01.bean.Instanll.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fang.day03.web.install.annotation.respository.UserDao;

@Component("userServiceId")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class UserServiceImpl implements UserService {

	@Value("12")
	private Integer length;

	@Autowired
	@Qualifier("user")
	private User user;

	@Resource(name = "person")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	/**
	 * 代表的是初始化方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("执行初始化方法");
	}

	/**
	 * 代表的是销毁的方法实现
	 */
	@PreDestroy
	public void destory() {
		System.out.println("执行销毁方法");
	}

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("添加用户成功");

		/**
		 * 在里面调用Dao层的实现
		 * 
		 */
		userDao.getUser();

	}

}
