package com.lee.bean;

public class Quest {
	private int id;
	private String stuNum;
	private String userName;
	private String quest_title;
	private String quest;
	private String sendTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public String getQuest_title() {
		return quest_title;
	}

	public void setQuest_title(String quest_title) {
		this.quest_title = quest_title;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String[] s=new String[6];
		s[0]=id+"";
		s[1]=stuNum;
		s[2]=userName;
		s[3]=quest_title;
		s[4]=quest;
		s[5]=sendTime;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++) {
			sb. append(s[i]+"+");
		}
		String newStr = sb.toString();
//		System.out.println(newStr);
		return newStr;
	}
}
