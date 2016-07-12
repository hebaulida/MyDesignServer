package com.lee.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库工具类
 * 
 * @author user
 * 
 */
public class DBUtil {
	private static String DRIVER = null;
	private static String URL = null;
	private static String USER = null;
	private static String PASSWORD = null;

	// 构造方法私有化
	private DBUtil() {
	};

	/**
	 * 加载数据库驱动
	 */
	static {
		initConfig();
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化配置参数
	 */
	private static void initConfig() {
//		ResourceBundle res = ResourceBundle.getBundle("com.uplooking.jdbc.db-config");
		//属性文件操作的工具类 
		Properties config = new Properties();
		//获取文件输入流
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/lee/util/db-config.properties");
		try {
			config.load(in);//装载配置文件流
			//获取配置文件中对应的内容(key)
			DRIVER = config.getProperty("jdbc.driver");
			URL = config.getProperty("jdbc.url");
			USER = config.getProperty("jdbc.user");
			PASSWORD = config.getProperty("jdbc.password");
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param rs
	 * @param state
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement state, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (state != null)
				state.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 测试连接是否成功
	public static void main(String[] args) {
		Connection conn = DBUtil.getConnection();
		System.out.println("success");
	}
}
