package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Blog {
		@Id
	    private String blogId;
		private String title;
		private int usersID;
		private Date dateOfCreation;
		private String content;
		private String category;
		private int approved;
		private String blogCreationDate;
		
		
		public String getBlogCreationDate() {
			return blogCreationDate;
		}

		public void setBlogCreationDate(String blogCreationDate) {
			this.blogCreationDate = blogCreationDate;
		}

		public int getApproved() {
			return approved;
		}

		public int isApproved() {
			return approved;
		}

		public void setApproved(int approved) {
			this.approved = approved;
		}

		public int getUsersID() {
			return usersID;
		}

		public void setUsersID(int usersID) {
			this.usersID = usersID;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getBlogId() {
			return blogId;
		}
		public void setBlogId(String blogId) {
			this.blogId = blogId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		public Date getDateOfCreation() {
			return dateOfCreation;
		}
		public void setDateOfCreation(Date dateOfCreation) {
			this.dateOfCreation = dateOfCreation;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
}
