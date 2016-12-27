package com.niit.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.niit.dao.BlogCommentDAO;
import com.niit.model.BlogComment;

@RestController
public class BlogCommentController {
	@Autowired
	BlogCommentDAO blogCommentDAO;
	@RequestMapping(value="/addBlogComment",headers="Accept=application/json",method=RequestMethod.POST)
	public void addBlog(@RequestBody BlogComment blogComment, HttpSession session)
	{
		int userId=(Integer) session.getAttribute("loggedInUserId");
		blogComment.setUserID(userId);
		
		
		
				// Create an instance of SimpleDateFormat used for formatting 
				// the string representation of date (month/day/year)
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

				// Get the date today using Calendar object.
				Date today = new Date();        
				// Using DateFormat format method we can create a string 
				// representation of a date with the defined format.
				String reportDate = df.format(today);

				// Print what date is today!
				System.out.println("Report Date: " + reportDate);
		
		blogComment.setDateTime(reportDate);
		
		//System.out.println("date of blog "+blogComment.getDateOfCreation());
		
		System.out.println("user id inside blog is "+userId);
		blogComment.setBlogLike(0);
		blogComment.setBlogDislike(0);
		blogCommentDAO.save(blogComment);
	}
	@RequestMapping(value="/viewBlogComments",headers="Accept=application/json",method=RequestMethod.GET)
	public String viewBlogs()
	{
		
		List<BlogComment> list= blogCommentDAO.list();
		
		Gson gson= new Gson();
		String object;
		object=gson.toJson(list);
		
		return object;
	}
	
	
	
	/*NOT IMPLEMENTED
	@RequestMapping(value="/updateBlog",headers="Accept=application/json",method=RequestMethod.PUT)
	public void updateBlog(@RequestBody Blog blog, HttpSession session)
	{
		
		System.out.println("Inside update blog");
		int userId=(Integer) session.getAttribute("loggedInUserId");
		blog.setUsersID(userId);
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
*/
}
