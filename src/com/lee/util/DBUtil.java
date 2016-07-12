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
 * ���ݿ⹤����
 * 
 * @author user
 * 
 */
public class DBUtil {
	private static String DRIVER = null;
	private static String URL = null;
	private static String USER = null;
	private static String PASSWORD = null;

	// ���췽��˽�л�
	private DBUtil() {
	};

	/**
	 * �������ݿ�����
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
	 * ��ʼ�����ò���
	 */
	private static void initConfig() {
//		ResourceBundle res = ResourceBundle.getBundle("com.uplooking.jdbc.db-config");
		//�����ļ������Ĺ����� 
		Properties config = new Properties();
		//��ȡ�ļ�������
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/lee/util/db-config.properties");
		try {
			config.load(in);//װ�������ļ���
			//��ȡ�����ļ��ж�Ӧ������(key)
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
	 * ��ȡ���ݿ����Ӷ���
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
	 * �ر����ݿ�����
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
	// ���������Ƿ�ɹ�
	public static void main(String[] args) {
		Connection conn = DBUtil.getConnection();
		System.out.println("success");
	}
}
