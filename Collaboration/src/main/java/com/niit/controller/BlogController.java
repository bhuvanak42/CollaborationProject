package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;

@RestController
public class BlogController {
	@Autowired
	BlogDao blogDao;
	@RequestMapping(value="/addBlog",headers="Accept=application/json",method=RequestMethod.POST)
	public void addBlog(@RequestBody Blog blog, HttpSession session)
	{
		int userId=(Integer) session.getAttribute("loggedInUserId");
		blog.setUsersID(userId);
		blog.setDateOfCreation(new Date());
		System.out.println("user id inside blog is "+userId);
		blog.setApproved(0);
		blogDao.saveOrUpdateBlog(blog);
	}
	@RequestMapping(value="/viewBlogs",headers="Accept=application/json",method=RequestMethod.GET)
	public List<Blog> viewBlogs()
	{
		return blogDao.getAllBlogs();
	}
	@RequestMapping(value="/updateBlog",headers="Accept=application/json",method=RequestMethod.PUT)
	public void updateBlog(@RequestBody Blog blog)
	{
		System.out.println("Inside update blog");
		blog.setDateOfCreation(new Date());
		blogDao.saveOrUpdateBlog(blog);
	}
	@RequestMapping(value="/deleteBlog/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
	public void deleteBlog(@PathVariable String id)
	{
		blogDao.delete(id);
	}
	
	@RequestMapping(value="/approveBlog/{i}",headers="Accept=application/json",method=RequestMethod.PUT)
	public void approveBlog(@RequestBody Blog blog,@PathVariable int i)
	{
		blog.setApproved(i);
		System.out.println("Inside approve blog");
		blogDao.saveOrUpdateBlog(blog);
		
	}

}
