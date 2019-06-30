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
		// return new DbUtilsCustomerDaoImpl();
		// return new JdbcCustomerDaoImpl();
		return (CustomerDao) getBean("customerDao");
	}

	/**
	 * 获取CustomerService的实现类对象
	 * 
	 * @return
	 */
	public static CustomerService getCustomerService() {
		// return new CustomerServiceImpl();
		return (CustomerService) getBean("customerService");
	}

	/**
	 * 通过反射提供对象创建方法
	 * 
	 * @param className
	 * @return
	 */
	public static Object getBean(String beanName) {
		// 读取配置文件，获取要实例化的对象的全类名
		//utils.BeanFactory
		String className = XMLUtils.readXML(beanName);
		try {
			//使用反射，通过类的全限定名，创建实例对象
			Class clazz = Class.forName(className);
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
