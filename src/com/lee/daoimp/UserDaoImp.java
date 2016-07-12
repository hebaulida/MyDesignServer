package com.lee.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lee.bean.User;
import com.lee.dao.UserDao;
import com.lee.util.DBUtil;

public class UserDaoImp extends UserDao{
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub 
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into `user_table`(stuNum,userName,role,class_,sex,pass) values(?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getStuNum());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getRole());
			ps.setString(4, user.getClass_());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getPass());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}
	}

	@Override
	public void select() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User newuser = null;
		String sql = "select stuNum,userName,role,class_,sex,pass from `user_table` where stuNum = ?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getStuNum());
//			ps.executeUpdate();
			rs = ps.executeQuery();
			while (rs.next()) {
				newuser = new User();
				newuser.setStuNum(rs.getString(1));
				newuser.setUserName(rs.getString(2));
				newuser.setRole(rs.getString(3));
				newuser.setClass_(rs.getString(4));
				newuser.setSex(rs.getString(5));
				newuser.setPass(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}
		user = newuser;
	}

	public void selectByStuNum() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User newuser = null;
		String sql = "select stuNum,userName,role,class_,sex,pass from `user_table` where stuNum = ?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getStuNum());
//			ps.executeUpdate();
			rs = ps.executeQuery();
			while (rs.next()) {
				newuser = new User();
				newuser.setStuNum(rs.getString(1));
				newuser.setUserName(rs.getString(2));
				newuser.setRole(rs.getString(3));
				newuser.setClass_(rs.getString(4));
				newuser.setSex(rs.getString(5));
				newuser.setPass(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}
		user = newuser;
	}
	public void selectLogin() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User newuser = null;
		String sql = "select stuNum,userName,role,class_,sex,pass from `user_table` where stuNum = ? &&pass like ?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getStuNum());
			ps.setString(2,user.getPass());
//			ps.executeUpdate();
			rs = ps.executeQuery();
			while (rs.next()) {
				newuser = new User();
				newuser.setStuNum(rs.getString(1));
				newuser.setUserName(rs.getString(2));
				newuser.setRole(rs.getString(3));
				newuser.setClass_(rs.getString(4));
				newuser.setSex(rs.getString(5));
				newuser.setPass(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}
		user = newuser;
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update `user_table` set userName=?,role=?,class_=?,sex=?,pass=?"
				+ " where stuNum=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
//			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUserName());
			ps.setString(2, user.getRole());
			ps.setString(3, user.getClass_());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getPass());
			ps.setString(6,user.getStuNum());
			
		
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new SQLException("update user by name error");
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}
	}

}
