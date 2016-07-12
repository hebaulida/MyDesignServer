package com.lee.dao;

import com.lee.bean.Answer;

public abstract class AnswerDao {
	Answer answer;
	public abstract void save();
	public abstract void select();
	public abstract void delete();
	public abstract void update();
}
