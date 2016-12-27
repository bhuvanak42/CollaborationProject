package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
//@Table(name="c_blogcomment")
@Component


public class BlogComment{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String blogID;
	private int userID;
	private String blogComment;
	private String dateTime;
	private int blogLike;
	private int blogDislike;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlogID() {
		return blogID;
	}
	public void setBlogID(String blogID) {
		this.blogID = blogID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	

	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		
		this.dateTime = dateTime;
	}
	
	public String getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	public int getBlogLike() {
		return blogLike;
	}
	public void setBlogLike(int blogLike) {
		this.blogLike = blogLike;
	}
	public int getBlogDislike() {
		return blogDislike;
	}
	public void setBlogDislike(int blogDislike) {
		this.blogDislike = blogDislike;
	}
	
}
