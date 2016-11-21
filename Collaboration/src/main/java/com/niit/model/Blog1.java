package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Blog1 {
		@Id
		@GeneratedValue
	    private int answerId;
		private String answer;
		private int usersID;
		private int questionId;
		private int answerLike;
		private int answerDislike;
		
		public int getAnswerId() {
			return answerId;
		}
		public void setAnswerId(int answerId) {
			this.answerId = answerId;
		}
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public int getUsersID() {
			return usersID;
		}
		public void setUsersID(int usersID) {
			this.usersID = usersID;
		}
		public int getQuestionId() {
			return questionId;
		}
		public void setQuestionId(int questionId) {
			this.questionId = questionId;
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
