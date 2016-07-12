package com.lee.dao;

import com.lee.bean.Quest;

public abstract class QuestDao {
	Quest mQuest;
	public abstract void save();
	public abstract void select();
	public abstract void delete();
	public abstract void update();
}
