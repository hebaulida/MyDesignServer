package com.lee.bean;

public class Answer {
	private int id;
	private String stuNum;
	private String userName;
	private String questid;
	private String answer;
	private String answerTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuestid() {
		return questid;
	}
	public void setQuestid(String questid) {
		this.questid = questid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String[] s=new String[8];
		s[0]=id+"";
		s[1]=stuNum;
		s[2]=userName;
		s[3]=questid;
		s[4]=answer;
		s[5]=answerTime;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++) {
			sb. append(s[i]+"+");
		}
		String newStr = sb.toString();
//		System.out.println(newStr);
		return newStr;
	}
}
