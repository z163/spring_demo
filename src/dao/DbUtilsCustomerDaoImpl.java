package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import po.Customer;
import utils.C3P0Utils;

public class DbUtilsCustomerDaoImpl implements CustomerDao {
	private QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());

	@Override
	public Integer insert(Customer customer) {
		System.out.println("DbUtilsCustomerDaoImpl...");
		Integer line = null;
		try {
			String sql = "INSERT INTO customer (cust_name ,cust_user_name) VALUES (?,?)";

			Object[] params = { customer.getCustName(), customer.getCustUserName() };
			line = runner.update(sql, params);
			System.out.println("customer" + line);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return line;
	}

}
