package com.niit.dao;

import java.util.List;

import com.niit.model.Blog1;

public interface Blog1Dao {

	public void saveOrUpdateBlog1(Blog1 blog1);

	public Blog1 getBlog1ById(String blog1Id);

	public List<Blog1> getAllBlog1s();
	
	public boolean delete(String blog1Id);
}