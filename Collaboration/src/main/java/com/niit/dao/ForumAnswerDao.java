package com.niit.dao;

import java.util.List;

import com.niit.model.ForumAnswer;

public interface ForumAnswerDao {
	
	public boolean saveOrUpdate(ForumAnswer answer);

	public boolean delete(int id);

	public List<ForumAnswer> getAnswers(int questionId);

	public List<ForumAnswer> list();
}
