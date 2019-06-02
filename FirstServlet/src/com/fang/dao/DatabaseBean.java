package com.fang.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseBean {

	private DataSource dataSource;

	public DatabaseBean() {
		// TODO Auto-generated constructor stub

		try {
			Context context = new InitialContext();

			Context envContext = (Context) context.lookup("java:/comp/env");

			dataSource = (DataSource) envContext.lookup("jndi/mysql");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isConnectedOK() {
		boolean ok = false;
		Connection connection = null;
		SQLException sqlException = null;
		try {

			connection = dataSource.getConnection();

			if (!connection.isClosed()) {
				ok = true;
			}

		} catch (Exception e) {
			sqlException = (SQLException) e;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {

					if (sqlException == null) {
						sqlException = (SQLException) e2;
					}
				}
			}
		}

		if (sqlException != null) {
			throw new RuntimeException(sqlException);
		}
		return ok;
	}

}
