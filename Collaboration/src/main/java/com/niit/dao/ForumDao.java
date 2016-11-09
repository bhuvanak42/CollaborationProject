package com.niit.dao;

import java.util.List;

import com.niit.model.*;

public interface ForumDao {
	void addQuestion(Forum forum);

	List<Forum> viewQuestions();

	void updateQuestion(Forum forum);

	void deleteQuestion(int id);

	Forum getQuestion(int id);
}
