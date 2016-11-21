package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.EventDao;
import com.niit.model.Event;

@RestController
public class EventController {
	@Autowired
	EventDao eventDao;
	@RequestMapping(value="/addEvent",headers="Accept=application/json",method=RequestMethod.POST)
	public void addEvent(@RequestBody Event event, HttpSession session)
	{
		int userId=(Integer) session.getAttribute("loggedInUserId");
		event.setUsersID(userId);
		
		System.out.println("user id inside event is "+userId);
		
		eventDao.saveOrUpdateEvent(event);
	}
	@RequestMapping(value="/viewEvents",headers="Accept=application/json",method=RequestMethod.GET)
	public List<Event> viewEvents()
	{
		return eventDao.getAllEvents();
	}
	@RequestMapping(value="/updateEvent",headers="Accept=application/json",method=RequestMethod.PUT)
	public void updateEvent(@RequestBody Event event, HttpSession session)
	{
		
		/*int userId=(Integer) session.getAttribute("loggedInUserId");
		event.setUsersID(userId);
		System.out.println("user id inside event is "+event.getUsersID());
		
		System.out.println("event id is "+event.getEventId());
		
		System.out.println("Inside update event");
		*/
		eventDao.saveOrUpdateEvent(event);
	}
	@RequestMapping(value="/deleteEvent/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
	public void deleteEvent(@PathVariable String id)
	{
	
		eventDao.delete(id);
	}

}
