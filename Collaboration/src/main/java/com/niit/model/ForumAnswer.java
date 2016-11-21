package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ForumAnswer {

	@Id
	@GeneratedValue
	private int answerId;
	private int questionId;
	private int userId;
	private String answer;
	private int answerLike;
	private int answerDislike;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAnswerLike() {
		return answerLike;
	}
	public void setAnswerLike(int answerLike) {
		this.answerLike = answerLike;
	}
	public int getAnswerDislike() {
		return answerDislike;
	}
	public void setAnswerDislike(int answerDislike) {
		this.answerDislike = answerDislike;
	}

}
