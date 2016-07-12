package com.lee.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.bean.Quest;
import com.lee.dao.QuestDao;
import com.lee.util.DBUtil;

public class QuestDaoImp extends QuestDao{
	private Quest mQuest;
	public Quest getQuest(){
		return mQuest;
	}
	public void setQuest(Quest mQuest){
		this.mQuest = mQuest;
	}
	@Override
	public void save() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into `quest_table`(stuNum,userName,quest_title,quest,sendTime) values(?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,mQuest.getStuNum());
			ps.setString(2, mQuest.getUserName());
			ps.setString(3, mQuest.getQuest_title());
			ps.setString(4, mQuest.getQuest());
			ps.setString(5, mQuest.getSendTime());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}
	public List<Quest> selectbytime(String timenow){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Quest mQuest=null;
		List<Quest> list = new ArrayList<Quest>();
		String sql = "select id,stuNum,userName,quest_title,quest,sendtime from `quest_table` where  sendtime<? order by sendtime desc";
//		String sql = "select ID,NAME,AGE,SEX from STUDENT";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, timenow);
			rs = ps.executeQuery();
			while (rs.next()) {
				mQuest = new Quest();
				mQuest.setId(rs.getInt(1));
				mQuest.setStuNum(rs.getString(2));
				mQuest.setUserName(rs.getString(3));
				mQuest.setQuest_title(rs.getString(4));
				mQuest.setQuest(rs.getString(5));
				mQuest.setSendTime(rs.getString(6));

				list.add(mQuest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new SQLException("find  STUDENT error");
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
		
	}
	public List<Quest> selectbyid(String stuNum){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Quest mQuest=null;
		List<Quest> list = new ArrayList<Quest>();
		String sql = "select id,stuNum,userName,quest_title,quest,sendtime from `quest_table` where  stuNum like ? order by sendtime";
//		String sql = "select ID,NAME,AGE,SEX from STUDENT";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stuNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				mQuest = new Quest();
				mQuest.setId(rs.getInt(1));
				mQuest.setStuNum(rs.getString(2));
				mQuest.setUserName(rs.getString(3));
				mQuest.setQuest_title(rs.getString(4));
				mQuest.setQuest(rs.getString(5));
				mQuest.setSendTime(rs.getString(6));

				list.add(mQuest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new SQLException("find  STUDENT error");
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
		
	}
	public List<Quest> selectbyQuestId(String questid){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Quest mQuest=null;
		List<Quest> list = new ArrayList<Quest>();
		String sql = "select id,stuNum,userName,quest_title,quest,sendtime from `quest_table` where  id like ? order by sendtime";
//		String sql = "select ID,NAME,AGE,SEX from STUDENT";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, questid);
			rs = ps.executeQuery();
			while (rs.next()) {
				mQuest = new Quest();
				mQuest.setId(rs.getInt(1));
				mQuest.setStuNum(rs.getString(2));
				mQuest.setUserName(rs.getString(3));
				mQuest.setQuest_title(rs.getString(4));
				mQuest.setQuest(rs.getString(5));
				mQuest.setSendTime(rs.getString(6));

				list.add(mQuest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new SQLException("find  STUDENT error");
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
