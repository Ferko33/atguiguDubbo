package com.ferko.gmall.service.impl;



import com.alibaba.dubbo.config.annotation.Service;
import com.ferko.gmall.bean.UserAddress;
import com.ferko.gmall.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * 1.将服务提供者注册到注册中心
 * 		1）导入dubbo依赖 \ 操作 zookeeper 的客户端
 * 		2）配置服务提供者（注解）
 * 2.让服务消费者去注册中心订阅服务提供者的服务地址
 *
 */
@Service //dubbo包下的注解
public class UserServiceImpl implements UserService {


	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl.....old...");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
		/*try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return Arrays.asList(address1,address2);
	}

}
