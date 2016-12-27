package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.BlogComment;

@Repository("blogCommentDAO")
public interface BlogCommentDAO {

	
	public boolean save(BlogComment blogComment);
	public List<BlogComment> list();
	public BlogComment get(int id); 
	
}
