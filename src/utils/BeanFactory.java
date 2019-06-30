package utils;

import dao.CustomerDao;
import dao.DbUtilsCustomerDaoImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

/**
 * 对象工厂
 * 
 * @author 怡吾宇
 *
 */
public class BeanFactory {

	/**
	 * 获取CustomerDao的实现类对象
	 * 
	 * @return
	 */
	public static CustomerDao getCustomerDao() {
		return new DbUtilsCustomerDaoImpl();
		// return new JdbcCustomerDaoImpl();
	}

	/**
	 * 获取CustomerService的实现类对象
	 * 
	 * @return
	 */
	public static CustomerService getCustomerService() {
		return new CustomerServiceImpl();
	}
}
