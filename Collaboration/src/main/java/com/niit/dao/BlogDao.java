package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDao {

	public void saveOrUpdateBlog(Blog blog);

	public Blog getBlogById(String blogId);

	public List<Blog> getAllBlogs();
	
	public boolean delete(String blogId);
}