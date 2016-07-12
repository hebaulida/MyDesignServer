package com.lee.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.bean.Answer;
import com.lee.bean.Quest;
import com.lee.dao.AnswerDao;
import com.lee.util.DBUtil;

public class AnswerDaoImp extends AnswerDao{
	private Answer mAnswer;
	public Answer getQuest(){
		return mAnswer;
	}
	public void setAnswer(Answer mAnswer){
		this.mAnswer = mAnswer;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into `ans_table`(stuNum,userName,questid,answer,answerTime) values(?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,mAnswer.getStuNum());
			ps.setString(2, mAnswer.getUserName());
			ps.setString(3, mAnswer.getQuestid());
			ps.setString(4, mAnswer.getAnswer());
			ps.setString(5, mAnswer.getAnswerTime());
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
	public List<Answer> selectbyid(String questid){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Answer mAnswer=null;
		List<Answer> list = new ArrayList<Answer>();
		String sql = "select id,stuNum,userName,questid,answer,answerTime from `ans_table` where  questid like ? order by answerTime";
//		String sql = "select ID,NAME,AGE,SEX from STUDENT";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, questid);
			rs = ps.executeQuery();
			while (rs.next()) {
				mAnswer = new Answer();
				mAnswer.setId(rs.getInt(1));
				mAnswer.setStuNum(rs.getString(2));
				mAnswer.setUserName(rs.getString(3));
				mAnswer.setQuestid(rs.getString(4));
				mAnswer.setAnswer(rs.getString(5));
				mAnswer.setAnswerTime(rs.getString(6));

				list.add(mAnswer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new SQLException("find  STUDENT error");
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return list;
		
	}
	public List<Answer> selectbyStuNum(String stuNum){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Answer mAnswer=null;
		List<Answer> list = new ArrayList<Answer>();
		String sql = "select questid from `ans_table` where  stuNum like ?";
//		String sql = "select ID,NAME,AGE,SEX from STUDENT";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stuNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				mAnswer = new Answer();
				mAnswer.setQuestid(rs.getString(1));

				list.add(mAnswer);
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
